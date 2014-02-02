package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;

public class PacketStatsToClient extends AbstractPacket {
	public int race, maxHp, de, maxDe, credits, attack, defense, arcana, discount, luck, reflex, stamina, speed, ar, maxAr, coolDown;
	public String ability = "SET ABILITY", denotation = "ABILITY INFO";
	public boolean goodEffect = true, ranged = true;//True For Now
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(race);
		buffer.writeInt(maxHp);
		buffer.writeInt(de);
		buffer.writeInt(maxDe);
		buffer.writeInt(credits);
		buffer.writeInt(attack);
		buffer.writeInt(defense);
		buffer.writeInt(arcana);
		buffer.writeInt(discount);
		buffer.writeInt(luck);
		buffer.writeInt(reflex);
		buffer.writeInt(stamina);
		buffer.writeInt(speed);
		buffer.writeInt(ar);
		buffer.writeInt(maxAr);
		buffer.writeInt(coolDown);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		race = buffer.readInt();
		maxHp = buffer.readInt();
		de = buffer.readInt();
		maxDe = buffer.readInt();
		credits = buffer.readInt();
		attack = buffer.readInt();
		defense = buffer.readInt();
		arcana = buffer.readInt();
		discount = buffer.readInt();
		luck = buffer.readInt();
		reflex = buffer.readInt();
		stamina = buffer.readInt();
		speed = buffer.readInt();
		ar = buffer.readInt();
		maxAr = buffer.readInt();
		coolDown = buffer.readInt();
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
		RPG.arcana = arcana;
		RPG.discount = discount;
		RPG.luck = luck;
		RPG.reflex = reflex;
		RPG.stamina = stamina;
		RPG.speed = speed;
		RPG.ar = ar;
		RPG.maxAr = maxAr;
		RPG.coolDown = coolDown;
		
		RPG.ability = ability;
		RPG.goodEfect = goodEffect ? "True" : "False";
		RPG.denotation = denotation;
		RPG.ranged = ranged ? "True" : "False";
	}

	@Override
	public void handleServerSide(EntityPlayer player) { }
}