package com.kunpeng.dianjin91.func;

import android.widget.Toast;

import com.adobe.fre.FREObject;
import com.bodong.dianjinweb.DianJinPlatform;
import com.bodong.dianjinweb.listener.AppActiveListener;
import com.kunpeng.dianjin91.extension.DianJin91Context;
import com.kunpeng.dianjin91.extension.DianJin91Extension;

public class InitDianJin extends KunPengFunc {

	public static DianJin91Context contextAct;
	 protected FREObject doCall(DianJin91Context ctx, FREObject[] ps)
	  {
		 contextAct = ctx;
	    super.doCall(ctx, ps);
	    
	    int id = getInt(ps, 0);
	    String key = getString(ps, 1);
	    int channel = getInt(ps, 2);
	    DianJinPlatform.initialize(ctx.getActivity(), id, key, channel);
	    DianJinPlatform.setAppActivedListener(new AppActiveListener() {
			
			@Override
			public void onSuccess(long arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(contextAct.getActivity(), "DownSuccess",
						Toast.LENGTH_SHORT).show();
				contextAct.dispatchStatusEventAsync("DownSuccess", Long.toString(arg0));
			}
			
			@Override
			public void onError(int errorCode, String errorMessage) {
				// TODO Auto-generated method stub
				switch (errorCode) {
				case DianJinPlatform.DIANJIN_NET_ERROR:// 网络不稳定
					Toast.makeText(contextAct.getActivity(), errorMessage,
							Toast.LENGTH_SHORT).show();
					break;
				case DianJinPlatform.DIANJIN_DUPLICATE_ACTIVATION:// 重复激活
					Toast.makeText(contextAct.getActivity(), errorMessage,
							Toast.LENGTH_SHORT).show();
					break;

				case DianJinPlatform.DIANJIN_ADVERTSING_EXPIRED:// 应用已下架
					Toast.makeText(contextAct.getActivity(), errorMessage,
							Toast.LENGTH_SHORT).show();
					break;

				case DianJinPlatform.DIANJIN_ACTIVATION_FAILURE:// 激活失败
					Toast.makeText(contextAct.getActivity(), errorMessage,
							Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
			}
		}});
	    return null;
	  }
}
