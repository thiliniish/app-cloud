/*
* Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.wso2.appcloud.integration.test.scenarios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.wso2.appcloud.integration.test.utils.AppCloudIntegrationTestConstants;
import org.wso2.appcloud.integration.test.utils.AppCloudIntegrationTestUtils;

public class JaggeryAS600M3ApplicationTestCase extends AppCloudIntegrationBaseTestCase {
    private static final Log log = LogFactory.getLog(JaggeryAS600M3ApplicationTestCase.class);

    public static final String TOMCAT_SERVER_STARTED_MESSAGE = "org.apache.catalina.startup.Catalina.start Server startup in";
    public static final String JAGGERY_APPLICATION_TYPE = "jaggery";

    public JaggeryAS600M3ApplicationTestCase() {
        super(AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_AS600M3_APP_RUNTIME_ID_KEY),
                AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_AS600M3_APP_FILE_NAME_KEY),
                JAGGERY_APPLICATION_TYPE,
                AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_AS600M3_APP_CONTENT),
                Long.parseLong(AppCloudIntegrationTestUtils.getPropertyValue(AppCloudIntegrationTestConstants.
                        JAGGERY_RUNTIME_START_TIMEOUT)),
                AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_AS600M3_APPLICATION_CONTEXT),
                AppCloudIntegrationTestUtils.getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_CONTAINER_SPEC),
                Boolean.parseBoolean(AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_SET_DEFAULT_VERSION)),
                AppCloudIntegrationTestUtils
                        .getPropertyValue(AppCloudIntegrationTestConstants.JAGGERY_DEFAULT_VERSION));
    }

    @Override
    protected void assertLogContent(String logContent) {
        Assert.assertTrue(logContent.contains(TOMCAT_SERVER_STARTED_MESSAGE),
                "Received log:" + logContent + " but expected line: " + TOMCAT_SERVER_STARTED_MESSAGE);

    }

}
