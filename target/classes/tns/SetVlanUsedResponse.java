
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for set_vlan_usedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="set_vlan_usedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="set_vlan_usedResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_vlan_usedResponse", propOrder = {
    "setVlanUsedResult"
})
public class SetVlanUsedResponse {

    @XmlElementRef(name = "set_vlan_usedResult", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> setVlanUsedResult;

    /**
     * Gets the value of the setVlanUsedResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSetVlanUsedResult() {
        return setVlanUsedResult;
    }

    /**
     * Sets the value of the setVlanUsedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSetVlanUsedResult(JAXBElement<String> value) {
        this.setVlanUsedResult = ((JAXBElement<String> ) value);
    }

}
