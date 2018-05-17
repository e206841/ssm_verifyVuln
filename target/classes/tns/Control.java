
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for control complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="control">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="control_state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host_ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control", propOrder = {
    "controlState",
    "hostIp"
})
public class Control {

    @XmlElementRef(name = "control_state", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> controlState;
    @XmlElementRef(name = "host_ip", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> hostIp;

    /**
     * Gets the value of the controlState property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getControlState() {
        return controlState;
    }

    /**
     * Sets the value of the controlState property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setControlState(JAXBElement<String> value) {
        this.controlState = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the hostIp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHostIp() {
        return hostIp;
    }

    /**
     * Sets the value of the hostIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHostIp(JAXBElement<String> value) {
        this.hostIp = ((JAXBElement<String> ) value);
    }

}
