package com.szyciov.supervision.basic.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.szyciov.supervision.basic.request.PlatformCompanyOperation;
import com.szyciov.supervision.enums.CommandEnum;
import com.szyciov.supervision.enums.InterfaceType;
import com.szyciov.supervision.enums.RequestType;
import com.szyciov.supervision.token.service.TokenService;
import com.szyciov.supervision.util.BasicRequest;
import com.szyciov.supervision.util.EntityInfoList;
import com.szyciov.supervision.util.GzwycApi;

/**
 * Created by admin on 2017/7/10.
 */
@Component
public class BasicService {

    /**
     *
     * @return
     * @throws IOException
     */
    public EntityInfoList<PlatformCompanyOperation> sendPlatformCompanyOperation(String str) throws IOException {
        String token = TokenService.getToken();
        BasicRequest req = new BasicRequest(str, InterfaceType.BASIC, CommandEnum.PTYYGM, RequestType.REQ,token);

        EntityInfoList<PlatformCompanyOperation> response = GzwycApi.send(req, new TypeReference<EntityInfoList<PlatformCompanyOperation>>(){});

        return response;
    }
}
