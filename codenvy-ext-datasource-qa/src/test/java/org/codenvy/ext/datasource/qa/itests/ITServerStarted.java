/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 * [2014] Codenvy, S.A.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package org.codenvy.ext.datasource.qa.itests;

import org.codenvy.ext.datasource.qa.concordion.CodenvyConcordionExtension;
import org.concordion.api.extension.Extension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.jboss.arquillian.phantom.resolver.ResolvingPhantomJSDriverService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(ConcordionRunner.class)
public class ITServerStarted {

    protected WebDriver               driver;

    @Extension
    public CodenvyConcordionExtension extension = new CodenvyConcordionExtension();

    @Before
    public void setUp() throws Exception {
        driver = new PhantomJSDriver(
                                     ResolvingPhantomJSDriverService.createDefaultService(),
                                     DesiredCapabilities.phantomjs());
        driver.manage().window().setSize(new Dimension(1024, 768));
        extension.setSeleniumDriver(driver);
    }

    public String access(String url) {
        driver.get(url);
        return "access";
    }

    public String displayDatasourceExplorerTab() {
        return new WebDriverWait(driver, 10)
                                            .until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.xpath("//div[@id='codenvyIdeWorkspaceViewImpl']/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/span")
                                                                     )).getText();
    }
    
    public String displayDatasourceMenu() {
        return new WebDriverWait(driver, 10)
                                            .until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.xpath("//div[@id='codenvyIdeWorkspaceViewImpl']/div[2]/div/div[2]/div/div[3]/div/div/table/tbody/tr/td[4]")
                                                                     )).getText();
    }

    @After
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
