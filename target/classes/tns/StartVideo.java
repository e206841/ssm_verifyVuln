
package tns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for start_video complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="start_video">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="container_uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="video_dir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="video_file_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "start_video", propOrder = {
    "containerUuid",
    "videoDir",
    "videoFileName"
})
public class StartVideo {

    @XmlElementRef(name = "container_uuid", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> containerUuid;
    @XmlElementRef(name = "video_dir", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> videoDir;
    @XmlElementRef(name = "video_file_name", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> videoFileName;

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
     * Gets the value of the videoDir property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVideoDir() {
        return videoDir;
    }

    /**
     * Sets the value of the videoDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVideoDir(JAXBElement<String> value) {
        this.videoDir = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the videoFileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVideoFileName() {
        return videoFileName;
    }

    /**
     * Sets the value of the videoFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVideoFileName(JAXBElement<String> value) {
        this.videoFileName = ((JAXBElement<String> ) value);
    }

}
