
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verify_image_nameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verify_image_nameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="verify_image_nameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verify_image_nameResponse", propOrder = {
    "verifyImageNameResult"
})
public class VerifyImageNameResponse {

    @XmlElementRef(name = "verify_image_nameResult", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> verifyImageNameResult;

    /**
     * Gets the value of the verifyImageNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVerifyImageNameResult() {
        return verifyImageNameResult;
    }

    /**
     * Sets the value of the verifyImageNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVerifyImageNameResult(JAXBElement<String> value) {
        this.verifyImageNameResult = ((JAXBElement<String> ) value);
    }

}
