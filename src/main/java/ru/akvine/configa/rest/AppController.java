package ru.akvine.configa.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.configa.rest.converters.AppConverter;
import ru.akvine.configa.rest.dto.app.AddAppRequest;
import ru.akvine.configa.rest.dto.app.ListAppRequest;
import ru.akvine.configa.rest.dto.common.Response;
import ru.akvine.configa.rest.meta.AppControllerMeta;
import ru.akvine.configa.services.AppService;
import ru.akvine.configa.services.dto.app.AppBean;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController implements AppControllerMeta {
    private final AppService appService;
    private final AppConverter appConverter;

    @Override
    public Response add(@Valid AddAppRequest request) {
        AppBean appBeanGet = appConverter.convertToAppBean(request);
        AppBean appBean = appService.add(appBeanGet);
        return appConverter.convertToAppAddResponse(appBean);
    }

    @Override
    public Response list(@Valid ListAppRequest request) {
        List<AppBean> appBeans = appService.list(request.getClientUuid());
        return appConverter.convertToListAppResponse(appBeans);
    }
}
