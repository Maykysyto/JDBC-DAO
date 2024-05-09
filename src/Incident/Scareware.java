public class Scareware extends Incident {
    private int FlowDuration;

    public Scareware(String FlowID, String SourceIP, int SourcePort, String DestinationID, int DestinationPort, int Protocol, String Label, int FlowDuration) {
        super(FlowID, SourceIP, SourcePort, DestinationID, DestinationPort, Protocol, Label);
        this.FlowDuration = FlowDuration;
    }

    // Métodos getter y setter para el nuevo atributo
    public Integer getFlowDuration() {
        return FlowDuration;
    }

    public void setFlowDuration(int flowDuration) {
        FlowDuration = flowDuration;
    }

    // Sobrescribir el método toString para incluir el nuevo atributo
    public String getdetailedString() {
        return "FlowID=" + getFlowID() + ", Source IP=" + getSourceIP() + ", SourcePort=" + getSourcePort() +
                ", Destination IP=" + getDestinationID() + ", DestinationPort=" + getDestinationPort() +
                ", Protocol=" + getProtocol() + ", Label=" + getLabel() + ", Flow Duration=" + FlowDuration;
    };

}


