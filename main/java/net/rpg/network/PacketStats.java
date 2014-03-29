package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;
import net.rpg.helper.DataHelper;

public class PacketStats extends AbstractPacket {
	private int race, maxHp, de, maxDe, credits, attack, defense, maxArcana, arcana, discount, luck, reflex, stamina, speed, cooldown, ability;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		System.err.println("ENCODING");
		buffer.writeInt(race);
		buffer.writeInt(maxHp);
		buffer.writeInt(de);
		buffer.writeInt(maxDe);
		buffer.writeInt(credits);
		buffer.writeInt(attack);
		buffer.writeInt(defense);
		buffer.writeInt(maxArcana);
		buffer.writeInt(arcana);
		buffer.writeInt(discount);
		buffer.writeInt(luck);
		buffer.writeInt(reflex);
		buffer.writeInt(stamina);
		buffer.writeInt(speed);
		buffer.writeInt(cooldown);
		buffer.writeInt(ability);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		System.err.println("DECODING");
		race = buffer.readInt();
		maxHp = buffer.readInt();
		de = buffer.readInt();
		maxDe = buffer.readInt();
		credits = buffer.readInt();
		attack = buffer.readInt();
		defense = buffer.readInt();
		maxArcana = buffer.readInt();
		arcana = buffer.readInt();
		discount = buffer.readInt();
		luck = buffer.readInt();
		reflex = buffer.readInt();
		stamina = buffer.readInt();
		speed = buffer.readInt();
		cooldown = buffer.readInt();
		ability = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		RPG.race = race;
		RPG.maxHp = maxHp;
		RPG.de = de;
		RPG.maxDe = maxDe;
		RPG.credits = credits;
		RPG.attack = attack;
		RPG.defense = defense;
		RPG.maxArcana = maxArcana;
		RPG.arcana = arcana;
		RPG.discount = discount;
		RPG.luck = luck;
		RPG.reflex = reflex;
		RPG.stamina = stamina;
		RPG.speed = speed;
		RPG.cooldown = cooldown;
		RPG.ability = ability;
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
	}

	public PacketStats applyStats(EntityPlayer player) {
		System.err.println("APPLYING STATS");
		race = DataHelper.getRace(player);
		maxHp = DataHelper.getMaxHp(player);
		de = DataHelper.getDe(player);
		maxDe = DataHelper.getMaxDe(player);
		credits = DataHelper.getCredits(player);
		attack = DataHelper.getAttack(player);
		defense = DataHelper.getDefense(player);
		maxArcana = DataHelper.getMaxArcana(player);
		arcana = DataHelper.getArcana(player);
		discount = DataHelper.getDiscount(player);
		luck = DataHelper.getLuck(player);
		reflex = DataHelper.getReflex(player);
		stamina = DataHelper.getStamina(player);
		speed = DataHelper.getSpeed(player);
		cooldown = DataHelper.getCooldown(player);
		ability = DataHelper.getAbility(player);
		return this;
	}
}
