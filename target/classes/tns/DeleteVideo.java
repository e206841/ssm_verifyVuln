
package tns;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for delete_video complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="delete_video">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="container_uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hard_delete" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "delete_video", propOrder = {
    "containerUuid",
    "hardDelete"
})
public class DeleteVideo {

    @XmlElementRef(name = "container_uuid", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> containerUuid;
    @XmlElementRef(name = "hard_delete", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<BigInteger> hardDelete;

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
     * Gets the value of the hardDelete property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getHardDelete() {
        return hardDelete;
    }

    /**
     * Sets the value of the hardDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setHardDelete(JAXBElement<BigInteger> value) {
        this.hardDelete = ((JAXBElement<BigInteger> ) value);
    }

}
