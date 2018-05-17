
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verify_image_tarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verify_image_tarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verify_image_tarResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verify_image_tarResponse", propOrder = {
    "verifyImageTarResult"
})
public class VerifyImageTarResponse {

    @XmlElementRef(name = "verify_image_tarResult", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> verifyImageTarResult;

    /**
     * Gets the value of the verifyImageTarResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVerifyImageTarResult() {
        return verifyImageTarResult;
    }

    /**
     * Sets the value of the verifyImageTarResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVerifyImageTarResult(JAXBElement<String> value) {
        this.verifyImageTarResult = ((JAXBElement<String> ) value);
    }

}
