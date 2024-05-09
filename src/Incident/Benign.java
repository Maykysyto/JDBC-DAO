import java.math.BigDecimal;

public class Benign extends Incident {
    private BigDecimal FlowPacket;
    private int TotalFlow;
    private BigDecimal PacketLength;
    private BigDecimal AvPacket;
    private int FlowDuration;

    public Benign(String FlowID, String SourceIP, int SourcePort, String DestinationID, int DestinationPort, int Protocol, String Label, int FlowDuration , int TotalFlow, BigDecimal FlowPacket, BigDecimal PacketLength, BigDecimal AvPacket) {
        super(FlowID, SourceIP, SourcePort, DestinationID, DestinationPort, Protocol, Label);
        this.FlowPacket = FlowPacket;
        this.TotalFlow = TotalFlow;
        this.PacketLength = PacketLength;
        this.AvPacket = AvPacket;
        this.FlowDuration = FlowDuration;
    }

    // Métodos getter y setter para los atributos adicionales
    public BigDecimal getFlowPacket() {
        return FlowPacket;
    }

    public void setFlowPacket(BigDecimal flowPacket) {
        FlowPacket = flowPacket;
    }

    public Integer getTotalFlow() {
        return TotalFlow;
    }

    public void setTotalFlow(int totalFlow) {
        TotalFlow = totalFlow;
    }

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

    public Integer getFlowDuration() {
        return FlowDuration;
    }

    public void setFlowDuration(int flowDuration) {
        FlowDuration = flowDuration;
    }

    // Sobrescribir el método toString para incluir los nuevos atributos
    public String getdetailedString() {
        return "Flow ID=" + getFlowID() + ", Source IP=" + getSourceIP() + ", SourcePort=" + getSourcePort() +
                ", Destination IP=" + getDestinationID() + ", DestinationPort=" + getDestinationPort() +
                ", Protocol=" + getProtocol() + ", Label=" + getLabel() +", Flow Duration=" + FlowDuration +", Total Fwd Packet=" + FlowPacket + ", Fwd Packets/s=" + TotalFlow +
                ", Packet Length Var=" + PacketLength + ", Av Packet Size=" + AvPacket + "}";
    }
}