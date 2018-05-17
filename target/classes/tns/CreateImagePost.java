
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for create_image_post complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="create_image_post">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="image_uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarabspath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "create_image_post", propOrder = {
    "imageUuid",
    "tarabspath"
})
public class CreateImagePost {

    @XmlElementRef(name = "image_uuid", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> imageUuid;
    @XmlElementRef(name = "tarabspath", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> tarabspath;

    /**
     * Gets the value of the imageUuid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImageUuid() {
        return imageUuid;
    }

    /**
     * Sets the value of the imageUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImageUuid(JAXBElement<String> value) {
        this.imageUuid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the tarabspath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTarabspath() {
        return tarabspath;
    }

    /**
     * Sets the value of the tarabspath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTarabspath(JAXBElement<String> value) {
        this.tarabspath = ((JAXBElement<String> ) value);
    }

}
