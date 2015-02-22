describe('アカウントの認証', function() {
	it('無料期間中はサービス利用可能', function() {
		//Given:アカウントを新規登録
		browser.get('http://localhost:9000/account/');
		element(by.model('loginId')).sendKeys('aaaa');
		element(by.buttonText('Save')).click();

		var todoList = element.all(by.repeater('todo in todos'));
		var status = element(by.binding('status'))
		expect(status.getText()).toEqual('409')
	    });
    });