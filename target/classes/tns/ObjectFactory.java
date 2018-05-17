
package tns;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tns package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateImageFromContainerResponse_QNAME = new QName("tns", "create_image_from_containerResponse");
    private final static QName _GetImageDetailsResponse_QNAME = new QName("tns", "get_image_detailsResponse");
    private final static QName _UpdateImageStateResponse_QNAME = new QName("tns", "update_image_stateResponse");
    private final static QName _SetVlanUsed_QNAME = new QName("tns", "set_vlan_used");
    private final static QName _CreateImage_QNAME = new QName("tns", "create_image");
    private final static QName _UpdateImageResponse_QNAME = new QName("tns", "update_imageResponse");
    private final static QName _RestartContainer_QNAME = new QName("tns", "restart_container");
    private final static QName _UpdateImage_QNAME = new QName("tns", "update_image");
    private final static QName _CreateImagePost_QNAME = new QName("tns", "create_image_post");
    private final static QName _DeleteImageResponse_QNAME = new QName("tns", "delete_imageResponse");
    private final static QName _HelloTestResponse_QNAME = new QName("tns", "hello_testResponse");
    private final static QName _RemoveSlaveResponse_QNAME = new QName("tns", "remove_slaveResponse");
    private final static QName _GetImageDetails_QNAME = new QName("tns", "get_image_details");
    private final static QName _AddSlaveResponse_QNAME = new QName("tns", "add_slaveResponse");
    private final static QName _GetContainerDetailsResponse_QNAME = new QName("tns", "get_container_detailsResponse");
    private final static QName _SetVlanUsedResponse_QNAME = new QName("tns", "set_vlan_usedResponse");
    private final static QName _UpdateContainerResponse_QNAME = new QName("tns", "update_containerResponse");
    private final static QName _VerifyImageTarResponse_QNAME = new QName("tns", "verify_image_tarResponse");
    private final static QName _DeleteVideo_QNAME = new QName("tns", "delete_video");
    private final static QName _DeleteContainer_QNAME = new QName("tns", "delete_container");
    private final static QName _StartVideo_QNAME = new QName("tns", "start_video");
    private final static QName _DownloadFileResponse_QNAME = new QName("tns", "download_fileResponse");
    private final static QName _DownloadFile_QNAME = new QName("tns", "download_file");
    private final static QName _DeleteVideoResponse_QNAME = new QName("tns", "delete_videoResponse");
    private final static QName _HelloTest_QNAME = new QName("tns", "hello_test");
    private final static QName _StopVideoResponse_QNAME = new QName("tns", "stop_videoResponse");
    private final static QName _StartContainerResponse_QNAME = new QName("tns", "start_containerResponse");
    private final static QName _UpdateImageState_QNAME = new QName("tns", "update_image_state");
    private final static QName _GetImagesResponse_QNAME = new QName("tns", "get_imagesResponse");
    private final static QName _VerifyImageName_QNAME = new QName("tns", "verify_image_name");
    private final static QName _Toslave_QNAME = new QName("tns", "toslave");
    private final static QName _VerifyImageNameResponse_QNAME = new QName("tns", "verify_image_nameResponse");
    private final static QName _GetContainers_QNAME = new QName("tns", "get_containers");
    private final static QName _Control_QNAME = new QName("tns", "control");
    private final static QName _DeleteContainerResponse_QNAME = new QName("tns", "delete_containerResponse");
    private final static QName _ToslaveResponse_QNAME = new QName("tns", "toslaveResponse");
    private final static QName _ExecContainerResponse_QNAME = new QName("tns", "exec_containerResponse");
    private final static QName _ExecContainer_QNAME = new QName("tns", "exec_container");
    private final static QName _VerifyImageTar_QNAME = new QName("tns", "verify_image_tar");
    private final static QName _UpdateContainer_QNAME = new QName("tns", "update_container");
    private final static QName _CreateImageFromContainer_QNAME = new QName("tns", "create_image_from_container");
    private final static QName _GetPhysicalinfoResponse_QNAME = new QName("tns", "get_physicalinfoResponse");
    private final static QName _StopContainerResponse_QNAME = new QName("tns", "stop_containerResponse");
    private final static QName _GetImages_QNAME = new QName("tns", "get_images");
    private final static QName _GetPhysicalall_QNAME = new QName("tns", "get_physicalall");
    private final static QName _StartContainer_QNAME = new QName("tns", "start_container");
    private final static QName _RestartContainerResponse_QNAME = new QName("tns", "restart_containerResponse");
    private final static QName _StopContainer_QNAME = new QName("tns", "stop_container");
    private final static QName _StopVideo_QNAME = new QName("tns", "stop_video");
    private final static QName _RemoveSlave_QNAME = new QName("tns", "remove_slave");
    private final static QName _DeleteImage_QNAME = new QName("tns", "delete_image");
    private final static QName _GetPhysicalinfo_QNAME = new QName("tns", "get_physicalinfo");
    private final static QName _ControlResponse_QNAME = new QName("tns", "controlResponse");
    private final static QName _GetContainerDetails_QNAME = new QName("tns", "get_container_details");
    private final static QName _AddSlave_QNAME = new QName("tns", "add_slave");
    private final static QName _GetPhysicalallResponse_QNAME = new QName("tns", "get_physicalallResponse");
    private final static QName _StartVideoResponse_QNAME = new QName("tns", "start_videoResponse");
    private final static QName _CreateContainer_QNAME = new QName("tns", "create_container");
    private final static QName _CreateImagePostResponse_QNAME = new QName("tns", "create_image_postResponse");
    private final static QName _CreateContainerResponse_QNAME = new QName("tns", "create_containerResponse");
    private final static QName _CreateImageResponse_QNAME = new QName("tns", "create_imageResponse");
    private final static QName _GetContainersResponse_QNAME = new QName("tns", "get_containersResponse");
    private final static QName _UpdateImageName_QNAME = new QName("tns", "name");
    private final static QName _UpdateImageDescription_QNAME = new QName("tns", "description");
    private final static QName _UpdateImageImageUuid_QNAME = new QName("tns", "image_uuid");
    private final static QName _UpdateImageResponseUpdateImageResult_QNAME = new QName("tns", "update_imageResult");
    private final static QName _StopVideoContainerUuid_QNAME = new QName("tns", "container_uuid");
    private final static QName _ControlResponseControlResult_QNAME = new QName("tns", "controlResult");
    private final static QName _DownloadFileLimitSize_QNAME = new QName("tns", "limit_size");
    private final static QName _DownloadFileSrcPath_QNAME = new QName("tns", "src_path");
    private final static QName _DownloadFileUuid_QNAME = new QName("tns", "uuid");
    private final static QName _DownloadFileDesPath_QNAME = new QName("tns", "des_path");
    private final static QName _GetImagesResponseGetImagesResult_QNAME = new QName("tns", "get_imagesResult");
    private final static QName _AddSlaveSlaveIp_QNAME = new QName("tns", "slave_ip");
    private final static QName _CreateImageResponseCreateImageResult_QNAME = new QName("tns", "create_imageResult");
    private final static QName _RemoveSlaveResponseRemoveSlaveResult_QNAME = new QName("tns", "remove_slaveResult");
    private final static QName _StartVideoResponseStartVideoResult_QNAME = new QName("tns", "start_videoResult");
    private final static QName _CreateImageFromContainerMsg_QNAME = new QName("tns", "msg");
    private final static QName _CreateImageFromContainerImageName_QNAME = new QName("tns", "image_name");
    private final static QName _CreateImageFromContainerAuthor_QNAME = new QName("tns", "author");
    private final static QName _CreateImagePostTarabspath_QNAME = new QName("tns", "tarabspath");
    private final static QName _RestartContainerResponseRestartContainerResult_QNAME = new QName("tns", "restart_containerResult");
    private final static QName _StopVideoResponseStopVideoResult_QNAME = new QName("tns", "stop_videoResult");
    private final static QName _ExecContainerResponseExecContainerResult_QNAME = new QName("tns", "exec_containerResult");
    private final static QName _SetVlanUsedStart_QNAME = new QName("tns", "start");
    private final static QName _SetVlanUsedEnd_QNAME = new QName("tns", "end");
    private final static QName _CreateContainerIsRun_QNAME = new QName("tns", "is_run");
    private final static QName _CreateContainerSameHost_QNAME = new QName("tns", "same_host");
    private final static QName _CreateContainerRam_QNAME = new QName("tns", "ram");
    private final static QName _CreateContainerPassword_QNAME = new QName("tns", "password");
    private final static QName _CreateContainerVolumes_QNAME = new QName("tns", "volumes");
    private final static QName _CreateContainerCpu_QNAME = new QName("tns", "cpu");
    private final static QName _CreateContainerNetworks_QNAME = new QName("tns", "networks");
    private final static QName _CreateContainerRootDiskSize_QNAME = new QName("tns", "root_disk_size");
    private final static QName _CreateContainerGpuOps_QNAME = new QName("tns", "gpu_ops");
    private final static QName _CreateContainerUseGpu_QNAME = new QName("tns", "use_gpu");
    private final static QName _DeleteImageResponseDeleteImageResult_QNAME = new QName("tns", "delete_imageResult");
    private final static QName _GetContainersResponseGetContainersResult_QNAME = new QName("tns", "get_containersResult");
    private final static QName _DownloadFileResponseDownloadFileResult_QNAME = new QName("tns", "download_fileResult");
    private final static QName _UpdateContainerResponseUpdateContainerResult_QNAME = new QName("tns", "update_containerResult");
    private final static QName _UpdateImageStateResponseUpdateImageStateResult_QNAME = new QName("tns", "update_image_stateResult");
    private final static QName _SetVlanUsedResponseSetVlanUsedResult_QNAME = new QName("tns", "set_vlan_usedResult");
    private final static QName _ControlControlState_QNAME = new QName("tns", "control_state");
    private final static QName _ControlHostIp_QNAME = new QName("tns", "host_ip");
    private final static QName _CreateImagePostResponseCreateImagePostResult_QNAME = new QName("tns", "create_image_postResult");
    private final static QName _DeleteVideoHardDelete_QNAME = new QName("tns", "hard_delete");
    private final static QName _StartContainerResponseStartContainerResult_QNAME = new QName("tns", "start_containerResult");
    private final static QName _ToslaveResponseToslaveResult_QNAME = new QName("tns", "toslaveResult");
    private final static QName _DeleteContainerResponseDeleteContainerResult_QNAME = new QName("tns", "delete_containerResult");
    private final static QName _GetImageDetailsResponseGetImageDetailsResult_QNAME = new QName("tns", "get_image_detailsResult");
    private final static QName _HelloTestI_QNAME = new QName("tns", "i");
    private final static QName _GetPhysicalallResponseGetPhysicalallResult_QNAME = new QName("tns", "get_physicalallResult");
    private final static QName _CreateImageFromContainerResponseCreateImageFromContainerResult_QNAME = new QName("tns", "create_image_from_containerResult");
    private final static QName _GetContainersHost_QNAME = new QName("tns", "host");
    private final static QName _GetContainersCreatedAt_QNAME = new QName("tns", "created_at");
    private final static QName _GetContainersState_QNAME = new QName("tns", "state");
    private final static QName _GetContainersImage_QNAME = new QName("tns", "image");
    private final static QName _GetContainerDetailsResponseGetContainerDetailsResult_QNAME = new QName("tns", "get_container_detailsResult");
    private final static QName _GetPhysicalinfoPhysicalUuid_QNAME = new QName("tns", "physical_uuid");
    private final static QName _VerifyImageNameResponseVerifyImageNameResult_QNAME = new QName("tns", "verify_image_nameResult");
    private final static QName _StartVideoVideoFileName_QNAME = new QName("tns", "video_file_name");
    private final static QName _StartVideoVideoDir_QNAME = new QName("tns", "video_dir");
    private final static QName _CreateImageDiskFormat_QNAME = new QName("tns", "disk_format");
    private final static QName _CreateImageOstype_QNAME = new QName("tns", "ostype");
    private final static QName _CreateImageContainerFormat_QNAME = new QName("tns", "container_format");
    private final static QName _DeleteVideoResponseDeleteVideoResult_QNAME = new QName("tns", "delete_videoResult");
    private final static QName _ExecContainerDetach_QNAME = new QName("tns", "detach");
    private final static QName _ExecContainerExecCmd_QNAME = new QName("tns", "exec_cmd");
    private final static QName _StopContainerResponseStopContainerResult_QNAME = new QName("tns", "stop_containerResult");
    private final static QName _HelloTestResponseHelloTestResult_QNAME = new QName("tns", "hello_testResult");
    private final static QName _GetImagesTrait_QNAME = new QName("tns", "trait");
    private final static QName _VerifyImageTarResponseVerifyImageTarResult_QNAME = new QName("tns", "verify_image_tarResult");
    private final static QName _CreateContainerResponseCreateContainerResult_QNAME = new QName("tns", "create_containerResult");
    private final static QName _GetPhysicalinfoResponseGetPhysicalinfoResult_QNAME = new QName("tns", "get_physicalinfoResult");
    private final static QName _AddSlaveResponseAddSlaveResult_QNAME = new QName("tns", "add_slaveResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateImage }
     * 
     */
    public UpdateImage createUpdateImage() {
        return new UpdateImage();
    }

    /**
     * Create an instance of {@link UpdateImageResponse }
     * 
     */
    public UpdateImageResponse createUpdateImageResponse() {
        return new UpdateImageResponse();
    }

    /**
     * Create an instance of {@link GetPhysicalall }
     * 
     */
    public GetPhysicalall createGetPhysicalall() {
        return new GetPhysicalall();
    }

    /**
     * Create an instance of {@link StopVideo }
     * 
     */
    public StopVideo createStopVideo() {
        return new StopVideo();
    }

    /**
     * Create an instance of {@link ControlResponse }
     * 
     */
    public ControlResponse createControlResponse() {
        return new ControlResponse();
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link GetImagesResponse }
     * 
     */
    public GetImagesResponse createGetImagesResponse() {
        return new GetImagesResponse();
    }

    /**
     * Create an instance of {@link RemoveSlaveResponse }
     * 
     */
    public RemoveSlaveResponse createRemoveSlaveResponse() {
        return new RemoveSlaveResponse();
    }

    /**
     * Create an instance of {@link CreateImageResponse }
     * 
     */
    public CreateImageResponse createCreateImageResponse() {
        return new CreateImageResponse();
    }

    /**
     * Create an instance of {@link AddSlave }
     * 
     */
    public AddSlave createAddSlave() {
        return new AddSlave();
    }

    /**
     * Create an instance of {@link StartVideoResponse }
     * 
     */
    public StartVideoResponse createStartVideoResponse() {
        return new StartVideoResponse();
    }

    /**
     * Create an instance of {@link CreateImageFromContainer }
     * 
     */
    public CreateImageFromContainer createCreateImageFromContainer() {
        return new CreateImageFromContainer();
    }

    /**
     * Create an instance of {@link CreateImagePost }
     * 
     */
    public CreateImagePost createCreateImagePost() {
        return new CreateImagePost();
    }

    /**
     * Create an instance of {@link StopVideoResponse }
     * 
     */
    public StopVideoResponse createStopVideoResponse() {
        return new StopVideoResponse();
    }

    /**
     * Create an instance of {@link StartContainer }
     * 
     */
    public StartContainer createStartContainer() {
        return new StartContainer();
    }

    /**
     * Create an instance of {@link RestartContainerResponse }
     * 
     */
    public RestartContainerResponse createRestartContainerResponse() {
        return new RestartContainerResponse();
    }

    /**
     * Create an instance of {@link ExecContainerResponse }
     * 
     */
    public ExecContainerResponse createExecContainerResponse() {
        return new ExecContainerResponse();
    }

    /**
     * Create an instance of {@link SetVlanUsed }
     * 
     */
    public SetVlanUsed createSetVlanUsed() {
        return new SetVlanUsed();
    }

    /**
     * Create an instance of {@link CreateContainer }
     * 
     */
    public CreateContainer createCreateContainer() {
        return new CreateContainer();
    }

    /**
     * Create an instance of {@link DeleteImageResponse }
     * 
     */
    public DeleteImageResponse createDeleteImageResponse() {
        return new DeleteImageResponse();
    }

    /**
     * Create an instance of {@link GetContainersResponse }
     * 
     */
    public GetContainersResponse createGetContainersResponse() {
        return new GetContainersResponse();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link UpdateContainerResponse }
     * 
     */
    public UpdateContainerResponse createUpdateContainerResponse() {
        return new UpdateContainerResponse();
    }

    /**
     * Create an instance of {@link DeleteImage }
     * 
     */
    public DeleteImage createDeleteImage() {
        return new DeleteImage();
    }

    /**
     * Create an instance of {@link UpdateImageStateResponse }
     * 
     */
    public UpdateImageStateResponse createUpdateImageStateResponse() {
        return new UpdateImageStateResponse();
    }

    /**
     * Create an instance of {@link SetVlanUsedResponse }
     * 
     */
    public SetVlanUsedResponse createSetVlanUsedResponse() {
        return new SetVlanUsedResponse();
    }

    /**
     * Create an instance of {@link Control }
     * 
     */
    public Control createControl() {
        return new Control();
    }

    /**
     * Create an instance of {@link CreateImagePostResponse }
     * 
     */
    public CreateImagePostResponse createCreateImagePostResponse() {
        return new CreateImagePostResponse();
    }

    /**
     * Create an instance of {@link DeleteVideo }
     * 
     */
    public DeleteVideo createDeleteVideo() {
        return new DeleteVideo();
    }

    /**
     * Create an instance of {@link StartContainerResponse }
     * 
     */
    public StartContainerResponse createStartContainerResponse() {
        return new StartContainerResponse();
    }

    /**
     * Create an instance of {@link ToslaveResponse }
     * 
     */
    public ToslaveResponse createToslaveResponse() {
        return new ToslaveResponse();
    }

    /**
     * Create an instance of {@link DeleteContainerResponse }
     * 
     */
    public DeleteContainerResponse createDeleteContainerResponse() {
        return new DeleteContainerResponse();
    }

    /**
     * Create an instance of {@link VerifyImageName }
     * 
     */
    public VerifyImageName createVerifyImageName() {
        return new VerifyImageName();
    }

    /**
     * Create an instance of {@link Toslave }
     * 
     */
    public Toslave createToslave() {
        return new Toslave();
    }

    /**
     * Create an instance of {@link GetImageDetailsResponse }
     * 
     */
    public GetImageDetailsResponse createGetImageDetailsResponse() {
        return new GetImageDetailsResponse();
    }

    /**
     * Create an instance of {@link HelloTest }
     * 
     */
    public HelloTest createHelloTest() {
        return new HelloTest();
    }

    /**
     * Create an instance of {@link UpdateContainer }
     * 
     */
    public UpdateContainer createUpdateContainer() {
        return new UpdateContainer();
    }

    /**
     * Create an instance of {@link GetPhysicalallResponse }
     * 
     */
    public GetPhysicalallResponse createGetPhysicalallResponse() {
        return new GetPhysicalallResponse();
    }

    /**
     * Create an instance of {@link CreateImageFromContainerResponse }
     * 
     */
    public CreateImageFromContainerResponse createCreateImageFromContainerResponse() {
        return new CreateImageFromContainerResponse();
    }

    /**
     * Create an instance of {@link RemoveSlave }
     * 
     */
    public RemoveSlave createRemoveSlave() {
        return new RemoveSlave();
    }

    /**
     * Create an instance of {@link GetContainers }
     * 
     */
    public GetContainers createGetContainers() {
        return new GetContainers();
    }

    /**
     * Create an instance of {@link StopContainer }
     * 
     */
    public StopContainer createStopContainer() {
        return new StopContainer();
    }

    /**
     * Create an instance of {@link GetContainerDetailsResponse }
     * 
     */
    public GetContainerDetailsResponse createGetContainerDetailsResponse() {
        return new GetContainerDetailsResponse();
    }

    /**
     * Create an instance of {@link GetPhysicalinfo }
     * 
     */
    public GetPhysicalinfo createGetPhysicalinfo() {
        return new GetPhysicalinfo();
    }

    /**
     * Create an instance of {@link UpdateImageState }
     * 
     */
    public UpdateImageState createUpdateImageState() {
        return new UpdateImageState();
    }

    /**
     * Create an instance of {@link VerifyImageNameResponse }
     * 
     */
    public VerifyImageNameResponse createVerifyImageNameResponse() {
        return new VerifyImageNameResponse();
    }

    /**
     * Create an instance of {@link StartVideo }
     * 
     */
    public StartVideo createStartVideo() {
        return new StartVideo();
    }

    /**
     * Create an instance of {@link GetContainerDetails }
     * 
     */
    public GetContainerDetails createGetContainerDetails() {
        return new GetContainerDetails();
    }

    /**
     * Create an instance of {@link RestartContainer }
     * 
     */
    public RestartContainer createRestartContainer() {
        return new RestartContainer();
    }

    /**
     * Create an instance of {@link DeleteContainer }
     * 
     */
    public DeleteContainer createDeleteContainer() {
        return new DeleteContainer();
    }

    /**
     * Create an instance of {@link CreateImage }
     * 
     */
    public CreateImage createCreateImage() {
        return new CreateImage();
    }

    /**
     * Create an instance of {@link VerifyImageTar }
     * 
     */
    public VerifyImageTar createVerifyImageTar() {
        return new VerifyImageTar();
    }

    /**
     * Create an instance of {@link DeleteVideoResponse }
     * 
     */
    public DeleteVideoResponse createDeleteVideoResponse() {
        return new DeleteVideoResponse();
    }

    /**
     * Create an instance of {@link ExecContainer }
     * 
     */
    public ExecContainer createExecContainer() {
        return new ExecContainer();
    }

    /**
     * Create an instance of {@link StopContainerResponse }
     * 
     */
    public StopContainerResponse createStopContainerResponse() {
        return new StopContainerResponse();
    }

    /**
     * Create an instance of {@link HelloTestResponse }
     * 
     */
    public HelloTestResponse createHelloTestResponse() {
        return new HelloTestResponse();
    }

    /**
     * Create an instance of {@link GetImages }
     * 
     */
    public GetImages createGetImages() {
        return new GetImages();
    }

    /**
     * Create an instance of {@link VerifyImageTarResponse }
     * 
     */
    public VerifyImageTarResponse createVerifyImageTarResponse() {
        return new VerifyImageTarResponse();
    }

    /**
     * Create an instance of {@link GetImageDetails }
     * 
     */
    public GetImageDetails createGetImageDetails() {
        return new GetImageDetails();
    }

    /**
     * Create an instance of {@link CreateContainerResponse }
     * 
     */
    public CreateContainerResponse createCreateContainerResponse() {
        return new CreateContainerResponse();
    }

    /**
     * Create an instance of {@link AddSlaveResponse }
     * 
     */
    public AddSlaveResponse createAddSlaveResponse() {
        return new AddSlaveResponse();
    }

    /**
     * Create an instance of {@link GetPhysicalinfoResponse }
     * 
     */
    public GetPhysicalinfoResponse createGetPhysicalinfoResponse() {
        return new GetPhysicalinfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImageFromContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_from_containerResponse")
    public JAXBElement<CreateImageFromContainerResponse> createCreateImageFromContainerResponse(CreateImageFromContainerResponse value) {
        return new JAXBElement<CreateImageFromContainerResponse>(_CreateImageFromContainerResponse_QNAME, CreateImageFromContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_image_detailsResponse")
    public JAXBElement<GetImageDetailsResponse> createGetImageDetailsResponse(GetImageDetailsResponse value) {
        return new JAXBElement<GetImageDetailsResponse>(_GetImageDetailsResponse_QNAME, GetImageDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateImageStateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_image_stateResponse")
    public JAXBElement<UpdateImageStateResponse> createUpdateImageStateResponse(UpdateImageStateResponse value) {
        return new JAXBElement<UpdateImageStateResponse>(_UpdateImageStateResponse_QNAME, UpdateImageStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetVlanUsed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "set_vlan_used")
    public JAXBElement<SetVlanUsed> createSetVlanUsed(SetVlanUsed value) {
        return new JAXBElement<SetVlanUsed>(_SetVlanUsed_QNAME, SetVlanUsed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image")
    public JAXBElement<CreateImage> createCreateImage(CreateImage value) {
        return new JAXBElement<CreateImage>(_CreateImage_QNAME, CreateImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_imageResponse")
    public JAXBElement<UpdateImageResponse> createUpdateImageResponse(UpdateImageResponse value) {
        return new JAXBElement<UpdateImageResponse>(_UpdateImageResponse_QNAME, UpdateImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "restart_container")
    public JAXBElement<RestartContainer> createRestartContainer(RestartContainer value) {
        return new JAXBElement<RestartContainer>(_RestartContainer_QNAME, RestartContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_image")
    public JAXBElement<UpdateImage> createUpdateImage(UpdateImage value) {
        return new JAXBElement<UpdateImage>(_UpdateImage_QNAME, UpdateImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImagePost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_post")
    public JAXBElement<CreateImagePost> createCreateImagePost(CreateImagePost value) {
        return new JAXBElement<CreateImagePost>(_CreateImagePost_QNAME, CreateImagePost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_imageResponse")
    public JAXBElement<DeleteImageResponse> createDeleteImageResponse(DeleteImageResponse value) {
        return new JAXBElement<DeleteImageResponse>(_DeleteImageResponse_QNAME, DeleteImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloTestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "hello_testResponse")
    public JAXBElement<HelloTestResponse> createHelloTestResponse(HelloTestResponse value) {
        return new JAXBElement<HelloTestResponse>(_HelloTestResponse_QNAME, HelloTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSlaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "remove_slaveResponse")
    public JAXBElement<RemoveSlaveResponse> createRemoveSlaveResponse(RemoveSlaveResponse value) {
        return new JAXBElement<RemoveSlaveResponse>(_RemoveSlaveResponse_QNAME, RemoveSlaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_image_details")
    public JAXBElement<GetImageDetails> createGetImageDetails(GetImageDetails value) {
        return new JAXBElement<GetImageDetails>(_GetImageDetails_QNAME, GetImageDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSlaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "add_slaveResponse")
    public JAXBElement<AddSlaveResponse> createAddSlaveResponse(AddSlaveResponse value) {
        return new JAXBElement<AddSlaveResponse>(_AddSlaveResponse_QNAME, AddSlaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContainerDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_container_detailsResponse")
    public JAXBElement<GetContainerDetailsResponse> createGetContainerDetailsResponse(GetContainerDetailsResponse value) {
        return new JAXBElement<GetContainerDetailsResponse>(_GetContainerDetailsResponse_QNAME, GetContainerDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetVlanUsedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "set_vlan_usedResponse")
    public JAXBElement<SetVlanUsedResponse> createSetVlanUsedResponse(SetVlanUsedResponse value) {
        return new JAXBElement<SetVlanUsedResponse>(_SetVlanUsedResponse_QNAME, SetVlanUsedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_containerResponse")
    public JAXBElement<UpdateContainerResponse> createUpdateContainerResponse(UpdateContainerResponse value) {
        return new JAXBElement<UpdateContainerResponse>(_UpdateContainerResponse_QNAME, UpdateContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyImageTarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_tarResponse")
    public JAXBElement<VerifyImageTarResponse> createVerifyImageTarResponse(VerifyImageTarResponse value) {
        return new JAXBElement<VerifyImageTarResponse>(_VerifyImageTarResponse_QNAME, VerifyImageTarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_video")
    public JAXBElement<DeleteVideo> createDeleteVideo(DeleteVideo value) {
        return new JAXBElement<DeleteVideo>(_DeleteVideo_QNAME, DeleteVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_container")
    public JAXBElement<DeleteContainer> createDeleteContainer(DeleteContainer value) {
        return new JAXBElement<DeleteContainer>(_DeleteContainer_QNAME, DeleteContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_video")
    public JAXBElement<StartVideo> createStartVideo(StartVideo value) {
        return new JAXBElement<StartVideo>(_StartVideo_QNAME, StartVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "download_fileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "download_file")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_videoResponse")
    public JAXBElement<DeleteVideoResponse> createDeleteVideoResponse(DeleteVideoResponse value) {
        return new JAXBElement<DeleteVideoResponse>(_DeleteVideoResponse_QNAME, DeleteVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "hello_test")
    public JAXBElement<HelloTest> createHelloTest(HelloTest value) {
        return new JAXBElement<HelloTest>(_HelloTest_QNAME, HelloTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_videoResponse")
    public JAXBElement<StopVideoResponse> createStopVideoResponse(StopVideoResponse value) {
        return new JAXBElement<StopVideoResponse>(_StopVideoResponse_QNAME, StopVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_containerResponse")
    public JAXBElement<StartContainerResponse> createStartContainerResponse(StartContainerResponse value) {
        return new JAXBElement<StartContainerResponse>(_StartContainerResponse_QNAME, StartContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateImageState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_image_state")
    public JAXBElement<UpdateImageState> createUpdateImageState(UpdateImageState value) {
        return new JAXBElement<UpdateImageState>(_UpdateImageState_QNAME, UpdateImageState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_imagesResponse")
    public JAXBElement<GetImagesResponse> createGetImagesResponse(GetImagesResponse value) {
        return new JAXBElement<GetImagesResponse>(_GetImagesResponse_QNAME, GetImagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyImageName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_name")
    public JAXBElement<VerifyImageName> createVerifyImageName(VerifyImageName value) {
        return new JAXBElement<VerifyImageName>(_VerifyImageName_QNAME, VerifyImageName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Toslave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "toslave")
    public JAXBElement<Toslave> createToslave(Toslave value) {
        return new JAXBElement<Toslave>(_Toslave_QNAME, Toslave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyImageNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_nameResponse")
    public JAXBElement<VerifyImageNameResponse> createVerifyImageNameResponse(VerifyImageNameResponse value) {
        return new JAXBElement<VerifyImageNameResponse>(_VerifyImageNameResponse_QNAME, VerifyImageNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContainers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_containers")
    public JAXBElement<GetContainers> createGetContainers(GetContainers value) {
        return new JAXBElement<GetContainers>(_GetContainers_QNAME, GetContainers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Control }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "control")
    public JAXBElement<Control> createControl(Control value) {
        return new JAXBElement<Control>(_Control_QNAME, Control.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_containerResponse")
    public JAXBElement<DeleteContainerResponse> createDeleteContainerResponse(DeleteContainerResponse value) {
        return new JAXBElement<DeleteContainerResponse>(_DeleteContainerResponse_QNAME, DeleteContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ToslaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "toslaveResponse")
    public JAXBElement<ToslaveResponse> createToslaveResponse(ToslaveResponse value) {
        return new JAXBElement<ToslaveResponse>(_ToslaveResponse_QNAME, ToslaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "exec_containerResponse")
    public JAXBElement<ExecContainerResponse> createExecContainerResponse(ExecContainerResponse value) {
        return new JAXBElement<ExecContainerResponse>(_ExecContainerResponse_QNAME, ExecContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "exec_container")
    public JAXBElement<ExecContainer> createExecContainer(ExecContainer value) {
        return new JAXBElement<ExecContainer>(_ExecContainer_QNAME, ExecContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyImageTar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_tar")
    public JAXBElement<VerifyImageTar> createVerifyImageTar(VerifyImageTar value) {
        return new JAXBElement<VerifyImageTar>(_VerifyImageTar_QNAME, VerifyImageTar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_container")
    public JAXBElement<UpdateContainer> createUpdateContainer(UpdateContainer value) {
        return new JAXBElement<UpdateContainer>(_UpdateContainer_QNAME, UpdateContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImageFromContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_from_container")
    public JAXBElement<CreateImageFromContainer> createCreateImageFromContainer(CreateImageFromContainer value) {
        return new JAXBElement<CreateImageFromContainer>(_CreateImageFromContainer_QNAME, CreateImageFromContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhysicalinfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalinfoResponse")
    public JAXBElement<GetPhysicalinfoResponse> createGetPhysicalinfoResponse(GetPhysicalinfoResponse value) {
        return new JAXBElement<GetPhysicalinfoResponse>(_GetPhysicalinfoResponse_QNAME, GetPhysicalinfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_containerResponse")
    public JAXBElement<StopContainerResponse> createStopContainerResponse(StopContainerResponse value) {
        return new JAXBElement<StopContainerResponse>(_StopContainerResponse_QNAME, StopContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_images")
    public JAXBElement<GetImages> createGetImages(GetImages value) {
        return new JAXBElement<GetImages>(_GetImages_QNAME, GetImages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhysicalall }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalall")
    public JAXBElement<GetPhysicalall> createGetPhysicalall(GetPhysicalall value) {
        return new JAXBElement<GetPhysicalall>(_GetPhysicalall_QNAME, GetPhysicalall.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_container")
    public JAXBElement<StartContainer> createStartContainer(StartContainer value) {
        return new JAXBElement<StartContainer>(_StartContainer_QNAME, StartContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "restart_containerResponse")
    public JAXBElement<RestartContainerResponse> createRestartContainerResponse(RestartContainerResponse value) {
        return new JAXBElement<RestartContainerResponse>(_RestartContainerResponse_QNAME, RestartContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_container")
    public JAXBElement<StopContainer> createStopContainer(StopContainer value) {
        return new JAXBElement<StopContainer>(_StopContainer_QNAME, StopContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_video")
    public JAXBElement<StopVideo> createStopVideo(StopVideo value) {
        return new JAXBElement<StopVideo>(_StopVideo_QNAME, StopVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSlave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "remove_slave")
    public JAXBElement<RemoveSlave> createRemoveSlave(RemoveSlave value) {
        return new JAXBElement<RemoveSlave>(_RemoveSlave_QNAME, RemoveSlave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_image")
    public JAXBElement<DeleteImage> createDeleteImage(DeleteImage value) {
        return new JAXBElement<DeleteImage>(_DeleteImage_QNAME, DeleteImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhysicalinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalinfo")
    public JAXBElement<GetPhysicalinfo> createGetPhysicalinfo(GetPhysicalinfo value) {
        return new JAXBElement<GetPhysicalinfo>(_GetPhysicalinfo_QNAME, GetPhysicalinfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ControlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "controlResponse")
    public JAXBElement<ControlResponse> createControlResponse(ControlResponse value) {
        return new JAXBElement<ControlResponse>(_ControlResponse_QNAME, ControlResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContainerDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_container_details")
    public JAXBElement<GetContainerDetails> createGetContainerDetails(GetContainerDetails value) {
        return new JAXBElement<GetContainerDetails>(_GetContainerDetails_QNAME, GetContainerDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSlave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "add_slave")
    public JAXBElement<AddSlave> createAddSlave(AddSlave value) {
        return new JAXBElement<AddSlave>(_AddSlave_QNAME, AddSlave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPhysicalallResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalallResponse")
    public JAXBElement<GetPhysicalallResponse> createGetPhysicalallResponse(GetPhysicalallResponse value) {
        return new JAXBElement<GetPhysicalallResponse>(_GetPhysicalallResponse_QNAME, GetPhysicalallResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartVideoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_videoResponse")
    public JAXBElement<StartVideoResponse> createStartVideoResponse(StartVideoResponse value) {
        return new JAXBElement<StartVideoResponse>(_StartVideoResponse_QNAME, StartVideoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_container")
    public JAXBElement<CreateContainer> createCreateContainer(CreateContainer value) {
        return new JAXBElement<CreateContainer>(_CreateContainer_QNAME, CreateContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImagePostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_postResponse")
    public JAXBElement<CreateImagePostResponse> createCreateImagePostResponse(CreateImagePostResponse value) {
        return new JAXBElement<CreateImagePostResponse>(_CreateImagePostResponse_QNAME, CreateImagePostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_containerResponse")
    public JAXBElement<CreateContainerResponse> createCreateContainerResponse(CreateContainerResponse value) {
        return new JAXBElement<CreateContainerResponse>(_CreateContainerResponse_QNAME, CreateContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_imageResponse")
    public JAXBElement<CreateImageResponse> createCreateImageResponse(CreateImageResponse value) {
        return new JAXBElement<CreateImageResponse>(_CreateImageResponse_QNAME, CreateImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContainersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_containersResponse")
    public JAXBElement<GetContainersResponse> createGetContainersResponse(GetContainersResponse value) {
        return new JAXBElement<GetContainersResponse>(_GetContainersResponse_QNAME, GetContainersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "name", scope = UpdateImage.class)
    public JAXBElement<String> createUpdateImageName(String value) {
        return new JAXBElement<String>(_UpdateImageName_QNAME, String.class, UpdateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "description", scope = UpdateImage.class)
    public JAXBElement<String> createUpdateImageDescription(String value) {
        return new JAXBElement<String>(_UpdateImageDescription_QNAME, String.class, UpdateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_uuid", scope = UpdateImage.class)
    public JAXBElement<String> createUpdateImageImageUuid(String value) {
        return new JAXBElement<String>(_UpdateImageImageUuid_QNAME, String.class, UpdateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_imageResult", scope = UpdateImageResponse.class)
    public JAXBElement<String> createUpdateImageResponseUpdateImageResult(String value) {
        return new JAXBElement<String>(_UpdateImageResponseUpdateImageResult_QNAME, String.class, UpdateImageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = StopVideo.class)
    public JAXBElement<String> createStopVideoContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, StopVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "controlResult", scope = ControlResponse.class)
    public JAXBElement<String> createControlResponseControlResult(String value) {
        return new JAXBElement<String>(_ControlResponseControlResult_QNAME, String.class, ControlResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "limit_size", scope = DownloadFile.class)
    public JAXBElement<String> createDownloadFileLimitSize(String value) {
        return new JAXBElement<String>(_DownloadFileLimitSize_QNAME, String.class, DownloadFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "src_path", scope = DownloadFile.class)
    public JAXBElement<String> createDownloadFileSrcPath(String value) {
        return new JAXBElement<String>(_DownloadFileSrcPath_QNAME, String.class, DownloadFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "uuid", scope = DownloadFile.class)
    public JAXBElement<String> createDownloadFileUuid(String value) {
        return new JAXBElement<String>(_DownloadFileUuid_QNAME, String.class, DownloadFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "des_path", scope = DownloadFile.class)
    public JAXBElement<String> createDownloadFileDesPath(String value) {
        return new JAXBElement<String>(_DownloadFileDesPath_QNAME, String.class, DownloadFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_imagesResult", scope = GetImagesResponse.class)
    public JAXBElement<String> createGetImagesResponseGetImagesResult(String value) {
        return new JAXBElement<String>(_GetImagesResponseGetImagesResult_QNAME, String.class, GetImagesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "slave_ip", scope = AddSlave.class)
    public JAXBElement<String> createAddSlaveSlaveIp(String value) {
        return new JAXBElement<String>(_AddSlaveSlaveIp_QNAME, String.class, AddSlave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_imageResult", scope = CreateImageResponse.class)
    public JAXBElement<String> createCreateImageResponseCreateImageResult(String value) {
        return new JAXBElement<String>(_CreateImageResponseCreateImageResult_QNAME, String.class, CreateImageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "remove_slaveResult", scope = RemoveSlaveResponse.class)
    public JAXBElement<String> createRemoveSlaveResponseRemoveSlaveResult(String value) {
        return new JAXBElement<String>(_RemoveSlaveResponseRemoveSlaveResult_QNAME, String.class, RemoveSlaveResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_videoResult", scope = StartVideoResponse.class)
    public JAXBElement<String> createStartVideoResponseStartVideoResult(String value) {
        return new JAXBElement<String>(_StartVideoResponseStartVideoResult_QNAME, String.class, StartVideoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = CreateImageFromContainer.class)
    public JAXBElement<String> createCreateImageFromContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, CreateImageFromContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "msg", scope = CreateImageFromContainer.class)
    public JAXBElement<String> createCreateImageFromContainerMsg(String value) {
        return new JAXBElement<String>(_CreateImageFromContainerMsg_QNAME, String.class, CreateImageFromContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_name", scope = CreateImageFromContainer.class)
    public JAXBElement<String> createCreateImageFromContainerImageName(String value) {
        return new JAXBElement<String>(_CreateImageFromContainerImageName_QNAME, String.class, CreateImageFromContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "author", scope = CreateImageFromContainer.class)
    public JAXBElement<String> createCreateImageFromContainerAuthor(String value) {
        return new JAXBElement<String>(_CreateImageFromContainerAuthor_QNAME, String.class, CreateImageFromContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "tarabspath", scope = CreateImagePost.class)
    public JAXBElement<String> createCreateImagePostTarabspath(String value) {
        return new JAXBElement<String>(_CreateImagePostTarabspath_QNAME, String.class, CreateImagePost.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_uuid", scope = CreateImagePost.class)
    public JAXBElement<String> createCreateImagePostImageUuid(String value) {
        return new JAXBElement<String>(_UpdateImageImageUuid_QNAME, String.class, CreateImagePost.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "restart_containerResult", scope = RestartContainerResponse.class)
    public JAXBElement<String> createRestartContainerResponseRestartContainerResult(String value) {
        return new JAXBElement<String>(_RestartContainerResponseRestartContainerResult_QNAME, String.class, RestartContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = StartContainer.class)
    public JAXBElement<String> createStartContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, StartContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_videoResult", scope = StopVideoResponse.class)
    public JAXBElement<String> createStopVideoResponseStopVideoResult(String value) {
        return new JAXBElement<String>(_StopVideoResponseStopVideoResult_QNAME, String.class, StopVideoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "exec_containerResult", scope = ExecContainerResponse.class)
    public JAXBElement<String> createExecContainerResponseExecContainerResult(String value) {
        return new JAXBElement<String>(_ExecContainerResponseExecContainerResult_QNAME, String.class, ExecContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start", scope = SetVlanUsed.class)
    public JAXBElement<BigInteger> createSetVlanUsedStart(BigInteger value) {
        return new JAXBElement<BigInteger>(_SetVlanUsedStart_QNAME, BigInteger.class, SetVlanUsed.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "end", scope = SetVlanUsed.class)
    public JAXBElement<BigInteger> createSetVlanUsedEnd(BigInteger value) {
        return new JAXBElement<BigInteger>(_SetVlanUsedEnd_QNAME, BigInteger.class, SetVlanUsed.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "name", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerName(String value) {
        return new JAXBElement<String>(_UpdateImageName_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "is_run", scope = CreateContainer.class)
    public JAXBElement<Boolean> createCreateContainerIsRun(Boolean value) {
        return new JAXBElement<Boolean>(_CreateContainerIsRun_QNAME, Boolean.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "same_host", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerSameHost(String value) {
        return new JAXBElement<String>(_CreateContainerSameHost_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "ram", scope = CreateContainer.class)
    public JAXBElement<BigInteger> createCreateContainerRam(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreateContainerRam_QNAME, BigInteger.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_name", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerImageName(String value) {
        return new JAXBElement<String>(_CreateImageFromContainerImageName_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "password", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerPassword(String value) {
        return new JAXBElement<String>(_CreateContainerPassword_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "volumes", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerVolumes(String value) {
        return new JAXBElement<String>(_CreateContainerVolumes_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "description", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerDescription(String value) {
        return new JAXBElement<String>(_UpdateImageDescription_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "cpu", scope = CreateContainer.class)
    public JAXBElement<BigInteger> createCreateContainerCpu(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreateContainerCpu_QNAME, BigInteger.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "networks", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerNetworks(String value) {
        return new JAXBElement<String>(_CreateContainerNetworks_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "root_disk_size", scope = CreateContainer.class)
    public JAXBElement<BigInteger> createCreateContainerRootDiskSize(BigInteger value) {
        return new JAXBElement<BigInteger>(_CreateContainerRootDiskSize_QNAME, BigInteger.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "gpu_ops", scope = CreateContainer.class)
    public JAXBElement<String> createCreateContainerGpuOps(String value) {
        return new JAXBElement<String>(_CreateContainerGpuOps_QNAME, String.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "use_gpu", scope = CreateContainer.class)
    public JAXBElement<Boolean> createCreateContainerUseGpu(Boolean value) {
        return new JAXBElement<Boolean>(_CreateContainerUseGpu_QNAME, Boolean.class, CreateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_imageResult", scope = DeleteImageResponse.class)
    public JAXBElement<String> createDeleteImageResponseDeleteImageResult(String value) {
        return new JAXBElement<String>(_DeleteImageResponseDeleteImageResult_QNAME, String.class, DeleteImageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_containersResult", scope = GetContainersResponse.class)
    public JAXBElement<String> createGetContainersResponseGetContainersResult(String value) {
        return new JAXBElement<String>(_GetContainersResponseGetContainersResult_QNAME, String.class, GetContainersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "download_fileResult", scope = DownloadFileResponse.class)
    public JAXBElement<String> createDownloadFileResponseDownloadFileResult(String value) {
        return new JAXBElement<String>(_DownloadFileResponseDownloadFileResult_QNAME, String.class, DownloadFileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_containerResult", scope = UpdateContainerResponse.class)
    public JAXBElement<String> createUpdateContainerResponseUpdateContainerResult(String value) {
        return new JAXBElement<String>(_UpdateContainerResponseUpdateContainerResult_QNAME, String.class, UpdateContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_uuid", scope = DeleteImage.class)
    public JAXBElement<String> createDeleteImageImageUuid(String value) {
        return new JAXBElement<String>(_UpdateImageImageUuid_QNAME, String.class, DeleteImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "update_image_stateResult", scope = UpdateImageStateResponse.class)
    public JAXBElement<String> createUpdateImageStateResponseUpdateImageStateResult(String value) {
        return new JAXBElement<String>(_UpdateImageStateResponseUpdateImageStateResult_QNAME, String.class, UpdateImageStateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "set_vlan_usedResult", scope = SetVlanUsedResponse.class)
    public JAXBElement<String> createSetVlanUsedResponseSetVlanUsedResult(String value) {
        return new JAXBElement<String>(_SetVlanUsedResponseSetVlanUsedResult_QNAME, String.class, SetVlanUsedResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "control_state", scope = Control.class)
    public JAXBElement<String> createControlControlState(String value) {
        return new JAXBElement<String>(_ControlControlState_QNAME, String.class, Control.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "host_ip", scope = Control.class)
    public JAXBElement<String> createControlHostIp(String value) {
        return new JAXBElement<String>(_ControlHostIp_QNAME, String.class, Control.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_postResult", scope = CreateImagePostResponse.class)
    public JAXBElement<String> createCreateImagePostResponseCreateImagePostResult(String value) {
        return new JAXBElement<String>(_CreateImagePostResponseCreateImagePostResult_QNAME, String.class, CreateImagePostResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = DeleteVideo.class)
    public JAXBElement<String> createDeleteVideoContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, DeleteVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "hard_delete", scope = DeleteVideo.class)
    public JAXBElement<BigInteger> createDeleteVideoHardDelete(BigInteger value) {
        return new JAXBElement<BigInteger>(_DeleteVideoHardDelete_QNAME, BigInteger.class, DeleteVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "start_containerResult", scope = StartContainerResponse.class)
    public JAXBElement<String> createStartContainerResponseStartContainerResult(String value) {
        return new JAXBElement<String>(_StartContainerResponseStartContainerResult_QNAME, String.class, StartContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "toslaveResult", scope = ToslaveResponse.class)
    public JAXBElement<String> createToslaveResponseToslaveResult(String value) {
        return new JAXBElement<String>(_ToslaveResponseToslaveResult_QNAME, String.class, ToslaveResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_containerResult", scope = DeleteContainerResponse.class)
    public JAXBElement<String> createDeleteContainerResponseDeleteContainerResult(String value) {
        return new JAXBElement<String>(_DeleteContainerResponseDeleteContainerResult_QNAME, String.class, DeleteContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "name", scope = VerifyImageName.class)
    public JAXBElement<String> createVerifyImageNameName(String value) {
        return new JAXBElement<String>(_UpdateImageName_QNAME, String.class, VerifyImageName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_image_detailsResult", scope = GetImageDetailsResponse.class)
    public JAXBElement<String> createGetImageDetailsResponseGetImageDetailsResult(String value) {
        return new JAXBElement<String>(_GetImageDetailsResponseGetImageDetailsResult_QNAME, String.class, GetImageDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = UpdateContainer.class)
    public JAXBElement<String> createUpdateContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, UpdateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "name", scope = UpdateContainer.class)
    public JAXBElement<String> createUpdateContainerName(String value) {
        return new JAXBElement<String>(_UpdateImageName_QNAME, String.class, UpdateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "description", scope = UpdateContainer.class)
    public JAXBElement<String> createUpdateContainerDescription(String value) {
        return new JAXBElement<String>(_UpdateImageDescription_QNAME, String.class, UpdateContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "i", scope = HelloTest.class)
    public JAXBElement<BigInteger> createHelloTestI(BigInteger value) {
        return new JAXBElement<BigInteger>(_HelloTestI_QNAME, BigInteger.class, HelloTest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalallResult", scope = GetPhysicalallResponse.class)
    public JAXBElement<String> createGetPhysicalallResponseGetPhysicalallResult(String value) {
        return new JAXBElement<String>(_GetPhysicalallResponseGetPhysicalallResult_QNAME, String.class, GetPhysicalallResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_image_from_containerResult", scope = CreateImageFromContainerResponse.class)
    public JAXBElement<String> createCreateImageFromContainerResponseCreateImageFromContainerResult(String value) {
        return new JAXBElement<String>(_CreateImageFromContainerResponseCreateImageFromContainerResult_QNAME, String.class, CreateImageFromContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "slave_ip", scope = RemoveSlave.class)
    public JAXBElement<String> createRemoveSlaveSlaveIp(String value) {
        return new JAXBElement<String>(_AddSlaveSlaveIp_QNAME, String.class, RemoveSlave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "host", scope = GetContainers.class)
    public JAXBElement<String> createGetContainersHost(String value) {
        return new JAXBElement<String>(_GetContainersHost_QNAME, String.class, GetContainers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "created_at", scope = GetContainers.class)
    public JAXBElement<String> createGetContainersCreatedAt(String value) {
        return new JAXBElement<String>(_GetContainersCreatedAt_QNAME, String.class, GetContainers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "state", scope = GetContainers.class)
    public JAXBElement<String> createGetContainersState(String value) {
        return new JAXBElement<String>(_GetContainersState_QNAME, String.class, GetContainers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image", scope = GetContainers.class)
    public JAXBElement<String> createGetContainersImage(String value) {
        return new JAXBElement<String>(_GetContainersImage_QNAME, String.class, GetContainers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = StopContainer.class)
    public JAXBElement<String> createStopContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, StopContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_container_detailsResult", scope = GetContainerDetailsResponse.class)
    public JAXBElement<String> createGetContainerDetailsResponseGetContainerDetailsResult(String value) {
        return new JAXBElement<String>(_GetContainerDetailsResponseGetContainerDetailsResult_QNAME, String.class, GetContainerDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "state", scope = UpdateImageState.class)
    public JAXBElement<String> createUpdateImageStateState(String value) {
        return new JAXBElement<String>(_GetContainersState_QNAME, String.class, UpdateImageState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_uuid", scope = UpdateImageState.class)
    public JAXBElement<String> createUpdateImageStateImageUuid(String value) {
        return new JAXBElement<String>(_UpdateImageImageUuid_QNAME, String.class, UpdateImageState.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "physical_uuid", scope = GetPhysicalinfo.class)
    public JAXBElement<String> createGetPhysicalinfoPhysicalUuid(String value) {
        return new JAXBElement<String>(_GetPhysicalinfoPhysicalUuid_QNAME, String.class, GetPhysicalinfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_nameResult", scope = VerifyImageNameResponse.class)
    public JAXBElement<String> createVerifyImageNameResponseVerifyImageNameResult(String value) {
        return new JAXBElement<String>(_VerifyImageNameResponseVerifyImageNameResult_QNAME, String.class, VerifyImageNameResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = GetContainerDetails.class)
    public JAXBElement<String> createGetContainerDetailsContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, GetContainerDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = StartVideo.class)
    public JAXBElement<String> createStartVideoContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, StartVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "video_file_name", scope = StartVideo.class)
    public JAXBElement<String> createStartVideoVideoFileName(String value) {
        return new JAXBElement<String>(_StartVideoVideoFileName_QNAME, String.class, StartVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "video_dir", scope = StartVideo.class)
    public JAXBElement<String> createStartVideoVideoDir(String value) {
        return new JAXBElement<String>(_StartVideoVideoDir_QNAME, String.class, StartVideo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = RestartContainer.class)
    public JAXBElement<String> createRestartContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, RestartContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "tarabspath", scope = VerifyImageTar.class)
    public JAXBElement<String> createVerifyImageTarTarabspath(String value) {
        return new JAXBElement<String>(_CreateImagePostTarabspath_QNAME, String.class, VerifyImageTar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "name", scope = CreateImage.class)
    public JAXBElement<String> createCreateImageName(String value) {
        return new JAXBElement<String>(_UpdateImageName_QNAME, String.class, CreateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "description", scope = CreateImage.class)
    public JAXBElement<String> createCreateImageDescription(String value) {
        return new JAXBElement<String>(_UpdateImageDescription_QNAME, String.class, CreateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "disk_format", scope = CreateImage.class)
    public JAXBElement<String> createCreateImageDiskFormat(String value) {
        return new JAXBElement<String>(_CreateImageDiskFormat_QNAME, String.class, CreateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "ostype", scope = CreateImage.class)
    public JAXBElement<String> createCreateImageOstype(String value) {
        return new JAXBElement<String>(_CreateImageOstype_QNAME, String.class, CreateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_format", scope = CreateImage.class)
    public JAXBElement<String> createCreateImageContainerFormat(String value) {
        return new JAXBElement<String>(_CreateImageContainerFormat_QNAME, String.class, CreateImage.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = DeleteContainer.class)
    public JAXBElement<String> createDeleteContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, DeleteContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "delete_videoResult", scope = DeleteVideoResponse.class)
    public JAXBElement<String> createDeleteVideoResponseDeleteVideoResult(String value) {
        return new JAXBElement<String>(_DeleteVideoResponseDeleteVideoResult_QNAME, String.class, DeleteVideoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "container_uuid", scope = ExecContainer.class)
    public JAXBElement<String> createExecContainerContainerUuid(String value) {
        return new JAXBElement<String>(_StopVideoContainerUuid_QNAME, String.class, ExecContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "detach", scope = ExecContainer.class)
    public JAXBElement<Boolean> createExecContainerDetach(Boolean value) {
        return new JAXBElement<Boolean>(_ExecContainerDetach_QNAME, Boolean.class, ExecContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "exec_cmd", scope = ExecContainer.class)
    public JAXBElement<String> createExecContainerExecCmd(String value) {
        return new JAXBElement<String>(_ExecContainerExecCmd_QNAME, String.class, ExecContainer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "stop_containerResult", scope = StopContainerResponse.class)
    public JAXBElement<String> createStopContainerResponseStopContainerResult(String value) {
        return new JAXBElement<String>(_StopContainerResponseStopContainerResult_QNAME, String.class, StopContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "hello_testResult", scope = HelloTestResponse.class)
    public JAXBElement<String> createHelloTestResponseHelloTestResult(String value) {
        return new JAXBElement<String>(_HelloTestResponseHelloTestResult_QNAME, String.class, HelloTestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "trait", scope = GetImages.class)
    public JAXBElement<String> createGetImagesTrait(String value) {
        return new JAXBElement<String>(_GetImagesTrait_QNAME, String.class, GetImages.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "verify_image_tarResult", scope = VerifyImageTarResponse.class)
    public JAXBElement<String> createVerifyImageTarResponseVerifyImageTarResult(String value) {
        return new JAXBElement<String>(_VerifyImageTarResponseVerifyImageTarResult_QNAME, String.class, VerifyImageTarResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "image_uuid", scope = GetImageDetails.class)
    public JAXBElement<String> createGetImageDetailsImageUuid(String value) {
        return new JAXBElement<String>(_UpdateImageImageUuid_QNAME, String.class, GetImageDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "create_containerResult", scope = CreateContainerResponse.class)
    public JAXBElement<String> createCreateContainerResponseCreateContainerResult(String value) {
        return new JAXBElement<String>(_CreateContainerResponseCreateContainerResult_QNAME, String.class, CreateContainerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "get_physicalinfoResult", scope = GetPhysicalinfoResponse.class)
    public JAXBElement<String> createGetPhysicalinfoResponseGetPhysicalinfoResult(String value) {
        return new JAXBElement<String>(_GetPhysicalinfoResponseGetPhysicalinfoResult_QNAME, String.class, GetPhysicalinfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tns", name = "add_slaveResult", scope = AddSlaveResponse.class)
    public JAXBElement<String> createAddSlaveResponseAddSlaveResult(String value) {
        return new JAXBElement<String>(_AddSlaveResponseAddSlaveResult_QNAME, String.class, AddSlaveResponse.class, value);
    }

}
