/*
 * Copyright 2013-2017 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.demo;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.test.mailru.LoginPage;

public class LoginTest extends AbstractTest {

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0005")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "Calculator", dsUid = "TUID", dsArgs = "username, password")
    public void testMailRuLogin(String username, String password) {
        LoginPage homePage = new LoginPage(getDriver());
        homePage.open();
        homePage.signIn(username, password);
        Assert.assertTrue(getDriver().getCurrentUrl().startsWith("https://e.mail.ru/messages/inbox"),
                "Mail Ru is not logged in");
    }
}