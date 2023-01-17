module service {
    requires transitive serviceApi;
    requires dto;

    provides com.epam.jmpServiceApi.Service  with com.epam.jmpCloudServiceImpl.ServiceImpl;

    exports com.epam.jmpCloudServiceImpl;
}