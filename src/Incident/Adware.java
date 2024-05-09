import java.math.BigDecimal;

public class Adware extends Incident {
    private BigDecimal FlowPacket;
    private int TotalFlow;


    public Adware(String FlowID, String SourceIP, int SourcePort, String DestinationIP, int DestinationPort, int Protocol, String Label, int TotalFlow, BigDecimal FlowPacket) {
        super(FlowID, SourceIP, SourcePort, DestinationIP, DestinationPort, Protocol, Label);

        this.FlowPacket = FlowPacket;
        this.TotalFlow = TotalFlow;
    }
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
    public String getdetailedString() {
        return "FlowID=" + getFlowID() + ", Source IP=" + getSourceIP() + ", SourcePort=" + getSourcePort() +
                ", Destination IP=" + getDestinationID() + ", DestinationPort=" + getDestinationPort() +
                ", Protocol=" + getProtocol() + ", Label=" + getLabel() +
                ", Total Fwd Packet=" + FlowPacket + ", Fwd Packets/s=" + TotalFlow +
                "}";
    }


}
