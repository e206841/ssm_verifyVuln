
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_physicalinfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_physicalinfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_physicalinfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_physicalinfoResponse", propOrder = {
    "getPhysicalinfoResult"
})
public class GetPhysicalinfoResponse {

    @XmlElementRef(name = "get_physicalinfoResult", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> getPhysicalinfoResult;

    /**
     * Gets the value of the getPhysicalinfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGetPhysicalinfoResult() {
        return getPhysicalinfoResult;
    }

    /**
     * Sets the value of the getPhysicalinfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGetPhysicalinfoResult(JAXBElement<String> value) {
        this.getPhysicalinfoResult = ((JAXBElement<String> ) value);
    }

}
