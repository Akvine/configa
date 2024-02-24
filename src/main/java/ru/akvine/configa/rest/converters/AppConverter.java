package ru.akvine.configa.rest.converters;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.configa.rest.dto.app.AddAppRequest;
import ru.akvine.configa.rest.dto.app.AddAppResponse;
import ru.akvine.configa.rest.dto.app.AppDto;
import ru.akvine.configa.rest.dto.app.ListAppResponse;
import ru.akvine.configa.services.dto.app.AppBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppConverter {
    public AppBean convertToAppBean(AddAppRequest request) {
        Preconditions.checkNotNull(request, "addAppRequest is null");
        return new AppBean()
                .setTitle(request.getTitle())
                .setClientUuid(request.getClientUuid());
    }

    public AddAppResponse convertToAppAddResponse(AppBean appBean) {
        Preconditions.checkNotNull(appBean, "appBean is null");
        return new AddAppResponse()
                .setApp(buildAppDto(appBean));
    }

    public ListAppResponse convertToListAppResponse(List<AppBean> appBeans) {
        Preconditions.checkNotNull(appBeans, "appBeans is null");
        return new ListAppResponse()
                .setApps(appBeans
                        .stream()
                        .map(this::buildAppDto)
                        .collect(Collectors.toList()));
    }

    private AppDto buildAppDto(AppBean appBean) {
        return new AppDto()
                .setUuid(appBean.getUuid())
                .setClientUuid(appBean.getClientBean().getUuid())
                .setTitle(appBean.getTitle());
    }
}
