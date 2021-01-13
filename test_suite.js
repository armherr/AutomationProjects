const { expect } = require('chai');
var webdriver = require('selenium-webdriver');

describe("Inner Suite 1", function () {
    let driver;
    this.timeout(0);

    before(async function () {
        driver = new webdriver.Builder().forBrowser('chrome').build();
        await driver.get('http://www.google.com');
    });

    it('Test 1', async function () {
        const title = await driver.getTitle();
        console.log(title);
        expect(title).to.equal('Google');
    });

    after(async function () {
        await driver.quit();
    });
});