import { WmsFrontendPage } from './app.po';

describe('wms-frontend App', () => {
  let page: WmsFrontendPage;

  beforeEach(() => {
    page = new WmsFrontendPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
