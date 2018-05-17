
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exec_container complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exec_container">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="container_uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exec_cmd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detach" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exec_container", propOrder = {
    "containerUuid",
    "execCmd",
    "detach"
})
public class ExecContainer {

    @XmlElementRef(name = "container_uuid", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> containerUuid;
    @XmlElementRef(name = "exec_cmd", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> execCmd;
    @XmlElementRef(name = "detach", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<Boolean> detach;

    /**
     * Gets the value of the containerUuid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContainerUuid() {
        return containerUuid;
    }

    /**
     * Sets the value of the containerUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContainerUuid(JAXBElement<String> value) {
        this.containerUuid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the execCmd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExecCmd() {
        return execCmd;
    }

    /**
     * Sets the value of the execCmd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExecCmd(JAXBElement<String> value) {
        this.execCmd = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the detach property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDetach() {
        return detach;
    }

    /**
     * Sets the value of the detach property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDetach(JAXBElement<Boolean> value) {
        this.detach = ((JAXBElement<Boolean> ) value);
    }

}
