
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for download_file complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="download_file">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limit_size" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="src_path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="des_path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "download_file", propOrder = {
    "uuid",
    "limitSize",
    "srcPath",
    "desPath"
})
public class DownloadFile {

    @XmlElementRef(name = "uuid", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> uuid;
    @XmlElementRef(name = "limit_size", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> limitSize;
    @XmlElementRef(name = "src_path", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> srcPath;
    @XmlElementRef(name = "des_path", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> desPath;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUuid(JAXBElement<String> value) {
        this.uuid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the limitSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLimitSize() {
        return limitSize;
    }

    /**
     * Sets the value of the limitSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLimitSize(JAXBElement<String> value) {
        this.limitSize = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the srcPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSrcPath() {
        return srcPath;
    }

    /**
     * Sets the value of the srcPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSrcPath(JAXBElement<String> value) {
        this.srcPath = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the desPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDesPath() {
        return desPath;
    }

    /**
     * Sets the value of the desPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDesPath(JAXBElement<String> value) {
        this.desPath = ((JAXBElement<String> ) value);
    }

}
