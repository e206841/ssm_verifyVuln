
package tns;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for create_container complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="create_container">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="image_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpu" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="ram" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="root_disk_size" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volumes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="networks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="same_host" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="use_gpu" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="gpu_ops" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is_run" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "create_container", propOrder = {
    "name",
    "description",
    "imageName",
    "cpu",
    "ram",
    "rootDiskSize",
    "password",
    "volumes",
    "networks",
    "sameHost",
    "useGpu",
    "gpuOps",
    "isRun"
})
public class CreateContainer {

    @XmlElementRef(name = "name", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "description", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "image_name", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> imageName;
    @XmlElementRef(name = "cpu", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<BigInteger> cpu;
    @XmlElementRef(name = "ram", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<BigInteger> ram;
    @XmlElementRef(name = "root_disk_size", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<BigInteger> rootDiskSize;
    @XmlElementRef(name = "password", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "volumes", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> volumes;
    @XmlElementRef(name = "networks", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> networks;
    @XmlElementRef(name = "same_host", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> sameHost;
    @XmlElementRef(name = "use_gpu", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<Boolean> useGpu;
    @XmlElementRef(name = "gpu_ops", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<String> gpuOps;
    @XmlElementRef(name = "is_run", namespace = "tns", type = JAXBElement.class)
    protected JAXBElement<Boolean> isRun;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the imageName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImageName() {
        return imageName;
    }

    /**
     * Sets the value of the imageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImageName(JAXBElement<String> value) {
        this.imageName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cpu property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCpu(JAXBElement<BigInteger> value) {
        this.cpu = ((JAXBElement<BigInteger> ) value);
    }

    /**
     * Gets the value of the ram property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getRam() {
        return ram;
    }

    /**
     * Sets the value of the ram property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setRam(JAXBElement<BigInteger> value) {
        this.ram = ((JAXBElement<BigInteger> ) value);
    }

    /**
     * Gets the value of the rootDiskSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getRootDiskSize() {
        return rootDiskSize;
    }

    /**
     * Sets the value of the rootDiskSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setRootDiskSize(JAXBElement<BigInteger> value) {
        this.rootDiskSize = ((JAXBElement<BigInteger> ) value);
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassword(JAXBElement<String> value) {
        this.password = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the volumes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVolumes() {
        return volumes;
    }

    /**
     * Sets the value of the volumes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVolumes(JAXBElement<String> value) {
        this.volumes = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the networks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNetworks() {
        return networks;
    }

    /**
     * Sets the value of the networks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNetworks(JAXBElement<String> value) {
        this.networks = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the sameHost property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSameHost() {
        return sameHost;
    }

    /**
     * Sets the value of the sameHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSameHost(JAXBElement<String> value) {
        this.sameHost = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the useGpu property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getUseGpu() {
        return useGpu;
    }

    /**
     * Sets the value of the useGpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setUseGpu(JAXBElement<Boolean> value) {
        this.useGpu = ((JAXBElement<Boolean> ) value);
    }

    /**
     * Gets the value of the gpuOps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGpuOps() {
        return gpuOps;
    }

    /**
     * Sets the value of the gpuOps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGpuOps(JAXBElement<String> value) {
        this.gpuOps = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the isRun property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsRun() {
        return isRun;
    }

    /**
     * Sets the value of the isRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsRun(JAXBElement<Boolean> value) {
        this.isRun = ((JAXBElement<Boolean> ) value);
    }

}
