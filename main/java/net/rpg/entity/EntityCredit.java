package net.rpg.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.rpg.helper.DataHelper;
import net.rpg.helper.ItemHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCredit extends Entity {
    public int CreditColor;
    public int CreditOrbAge;
    public int field_70532_c;
    private int CreditOrbHealth = 5;
    public int CreditValue;
    private EntityPlayer closestPlayer;
    private int CreditTargetColor;
    private ItemStack stack;

    public EntityCredit(World par1World, double par2, double par4, double par6, int par8) {
        super(par1World);
        this.setSize(0.5F, 0.5F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(par2, par4, par6);
        this.rotationYaw = (float)(Math.random() * 360.0D);
        this.CreditValue = par8;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public EntityCredit(World par1World) {
        super(par1World);
        this.setSize(0.25F, 0.25F);
        this.yOffset = this.height / 2.0F;
    }

    protected void entityInit() {}

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1) {
        float f1 = 0.5F;

        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f1 > 1.0F) {
            f1 = 1.0F;
        }

        int i = super.getBrightnessForRender(par1);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f1 * 15.0F * 16.0F);

        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    public void onUpdate() {
        super.onUpdate();

        if (this.field_70532_c > 0) {
            --this.field_70532_c;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.029999999329447746D;

        if (this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)).getMaterial() == Material.lava) {
            this.playSound("random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
        }

        this.func_145771_j(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0D, this.posZ);
        double d0 = 8.0D;

        if (this.CreditTargetColor < this.CreditColor - 20 + this.getEntityId() % 100) {
            if (this.closestPlayer == null || this.closestPlayer.getDistanceSqToEntity(this) > d0 * d0) {
                this.closestPlayer = this.worldObj.getClosestPlayerToEntity(this, d0);
            }

            this.CreditTargetColor = this.CreditColor;
        }

        if (this.closestPlayer != null) {
            double d1 = (this.closestPlayer.posX - this.posX) / d0;
            double d2 = (this.closestPlayer.posY + (double)this.closestPlayer.getEyeHeight() - this.posY) / d0;
            double d3 = (this.closestPlayer.posZ - this.posZ) / d0;
            double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 1.0D - d4;

            if (d5 > 0.0D) {
                d5 *= d5;
            }
        }

        float f = 0.98F;

        if (this.onGround) {
            f = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.98F;
        }
        
        if (this.onGround) {
            this.motionY *= -0.8999999761581421D;
        }

        ++this.CreditColor;
        ++this.CreditOrbAge;

        if (this.CreditOrbAge >= 6000) {
            this.setDead();
        }
    }

    public boolean handleWaterMovement() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
    }

    protected void dealFireDamage(int par1) {
        this.attackEntityFrom(DamageSource.inFire, (float)par1);
    }

    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else {
            this.setBeenAttacked();
            this.CreditOrbHealth = (int)((float)this.CreditOrbHealth - par2);

            if (this.CreditOrbHealth <= 0) {
                this.setDead();
            }
            return false;
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setShort("Health", (short)((byte)this.CreditOrbHealth));
        par1NBTTagCompound.setShort("Age", (short)this.CreditOrbAge);
        par1NBTTagCompound.setShort("Value", (short)this.CreditValue);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        this.CreditOrbHealth = par1NBTTagCompound.getShort("Health") & 255;
        this.CreditOrbAge = par1NBTTagCompound.getShort("Age");
        this.CreditValue = par1NBTTagCompound.getShort("Value");
    }

    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
        if (!this.worldObj.isRemote) {
            if (this.field_70532_c == 0) {
                this.worldObj.playSoundAtEntity(par1EntityPlayer, "random.orb", 0.1F, 0.5F * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.8F));
                par1EntityPlayer.onItemPickup(this, 1);
                this.setDead();
            }
        }
        stack = new ItemStack(ItemHelper.getItem("credit"));
        if(!worldObj.isRemote) {
			if(par1EntityPlayer instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) par1EntityPlayer;
				DataHelper.setCredits(p, DataHelper.getCredits(p) + stack.stackSize);
				p.inventory.addItemStackToInventory(stack);
			} else {
				stack = null;
			}
		} else {
			if(par1EntityPlayer instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) par1EntityPlayer;
				p.inventory.addItemStackToInventory(stack);
			} else {
				stack = null;
			}
		}
    }

    public int getCreditValue() {
        return this.CreditValue;
    }

    @SideOnly(Side.CLIENT)
    public int getTextureByCredit() {
        return this.CreditValue >= 2477 ? 10 : (this.CreditValue >= 1237 ? 9 : (this.CreditValue >= 617 ? 8 : (this.CreditValue >= 307 ? 7 : (this.CreditValue >= 149 ? 6 : (this.CreditValue >= 73 ? 5 : (this.CreditValue >= 37 ? 4 : (this.CreditValue >= 17 ? 3 : (this.CreditValue >= 7 ? 2 : (this.CreditValue >= 3 ? 1 : 0)))))))));
    }

    public static int getCreditSplit(int par0) {
        return par0 >= 2477 ? 2477 : (par0 >= 1237 ? 1237 : (par0 >= 617 ? 617 : (par0 >= 307 ? 307 : (par0 >= 149 ? 149 : (par0 >= 73 ? 73 : (par0 >= 37 ? 37 : (par0 >= 17 ? 17 : (par0 >= 7 ? 7 : (par0 >= 3 ? 3 : 1)))))))));
    }

    public boolean canAttackWithItem() {
        return false;
    }
}