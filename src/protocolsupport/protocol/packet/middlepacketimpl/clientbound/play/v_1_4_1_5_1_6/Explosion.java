package protocolsupport.protocol.packet.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middlepacket.clientbound.play.MiddleExplosion;
import protocolsupport.protocol.packet.middlepacketimpl.PacketData;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class Explosion extends MiddleExplosion<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) {
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_EXPLOSION_ID, version);
		serializer.writeDouble(x);
		serializer.writeDouble(y);
		serializer.writeDouble(z);
		serializer.writeFloat(radius);
		serializer.writeInt(blocks.length);
		for (AffectedBlock block : blocks) {
			serializer.writeByte(block.offX);
			serializer.writeByte(block.offY);
			serializer.writeByte(block.offZ);
		}
		serializer.writeFloat(pMotX);
		serializer.writeFloat(pMotY);
		serializer.writeFloat(pMotZ);
		return RecyclableSingletonList.create(serializer);
	}

}