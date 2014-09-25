91DianJin-ane
=============

91点金广告有积分版积分墙ane(android版)

使用流程：
一.注册：
先去官网注册账号：http://mjoy.91.com/index.php
二.商务联系：
我只能告诉你联系他们的商务合作，会有很多好处，联系QQ：764545561，可以说是逐鹿介绍的。
三.加入ane到工程中：
在项目的-app.xml文件的android配置中，加入下面的代码：
<activity android:name="com.bodong.dianjinweb.downloadmanager.DianJinDownloadManager" 
				android:configChanges="orientation|keyboardHidden" 
				android:launchMode="singleTask" 
				android:theme="@android:style/Theme.Black.NoTitleBar" /> 
				<activity android:name="com.bodong.dianjinweb.web.DianjinWebAcitivity" 
				android:configChanges="orientation|keyboardHidden" 
				android:launchMode="singleTask" 
				android:theme="@android:style/Theme.Black.NoTitleBar" /> 
				<service android:name="com.bodong.dianjinweb.service.DianJinService" />
	
	项目中使用：
	1.初始化：
	      if (DianJin91.instance.supportDevice)
				{
					DianJin91.instance.setKeys(appid,appkey,1001);
					DianJin91.instance.addEventListener(DianJinEvent.DOWN_SUCCESS, onAddScore);
				}
				
				//积分奖励获取成功返回
				protected static function onAddScore(event:DianJinEvent):void
    		{
    			trace("积分+"event.data);
    		}
	2.显示积分墙：
	      DianJin91.instance.showInterstitial();
				
