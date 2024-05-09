import java.math.BigDecimal;

public class SMS extends Incident {
    private BigDecimal PacketLength;
    private BigDecimal AvPacket;

    public SMS(String FlowID, String SourceIP, int SourcePort, String DestinationID, int DestinationPort, int Protocol, String Label, BigDecimal PacketLength, BigDecimal AvPacket) {
        super(FlowID, SourceIP, SourcePort, DestinationID, DestinationPort, Protocol, Label);

        this.PacketLength = PacketLength;
        this.AvPacket = AvPacket;
    }

    // Métodos getter y setter para los nuevos atributos
    public BigDecimal getPacketLength() {
        return PacketLength;
    }

    public void setPacketLength(BigDecimal packetLength) {
        PacketLength = packetLength;
    }

    public BigDecimal getAvPacket() {
        return AvPacket;
    }

    public void setAvPacket(BigDecimal avPacket) {
        AvPacket = avPacket;
    }

    public String getdetailedString() {
        return "FlowID=" + getFlowID() + ", Source IP=" + getSourceIP() + ", SourcePort=" + getSourcePort() +
                ", Destination IP=" + getDestinationID() + ", DestinationPort=" + getDestinationPort() +
                ", Protocol=" + getProtocol() + ", Label=" + getLabel() + ", Packet Length=" + PacketLength + ", AvPacket=" + AvPacket + "}";
    }
}