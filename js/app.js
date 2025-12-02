var admobid = {};
if( /(android)/i.test(navigator.userAgent) ) {
    admobid = { // for Android
        banner: 'ca-app-pub-2379088028676063/3235214766',
        interstitial: 'ca-app-pub-2379088028676063/8282978575',
    };
} else if(/(ipod|iphone|ipad)/i.test(navigator.userAgent)) {
    admobid = { // for iOS
        banner: 'ca-app-pub-2379088028676063/3235214766',
        interstitial: 'ca-app-pub-2379088028676063/8282978575',
    };
} else {
    admobid = { // for Windows Phone
        banner: 'ca-app-pub-2379088028676063/3235214766',
        interstitial: 'ca-app-pub-2379088028676063/8282978575',
    };
}

var selected_pos_value = 8; //AdMob.AD_POSITION.BOTTOM_CENTER

function createSelectedBanner(){
    AdMob.removeBanner();
    var ads_size = 'BANNER';
    var ads_pos = selected_pos_value;
    if(AdMob) AdMob.createBanner({
        adId: admobid.banner,
        overlap: true,
        offsetTopBar: false,
        adSize: ads_size,
        position: ads_pos
    });
}

function showBannerAtPosition(){
    var ads_pos = selected_pos_value;
    if(AdMob) AdMob.showBanner( ads_pos );
}

function prepareInt(){
    AdMob.prepareInterstitial({
        adId:admobid.interstitial,
        autoShow: true
    });
}

function initialization(){
    AdMob.getAdSettings(function(info){
        console.log('adId: ' + info.adId + '\n' + 'adTrackingEnabled: ' + info.adTrackingEnabled);
    }, function(){
        console.log('failed to get user ad settings');
    });
    
    AdMob.setOptions({
        //adId: admobid.banner,
        adSize: 'SMART_BANNER',
        position: AdMob.AD_POSITION.BOTTOM_CENTER,
        isTesting: false, // set to true, to receiving test ad for testing purpose
        bgColor: 'black', // color name, or '#RRGGBB'
        autoShow: true // auto show interstitial ad when loaded, set to false if prepare/show
        // offsetTopBar: false, // avoid overlapped by status bar, for iOS7+
    });
    
    // new events, with variable to differentiate: adNetwork, adType, adEvent
    $(document).on('onAdFailLoad', function(e){
        // when jquery used, it will hijack the event, so we have to get data from original event
        if(typeof e.originalEvent !== 'undefined') e = e.originalEvent;
        var data = e.detail || e.data || e;
        /*
        alert('error: ' + data.error +
            ', reason: ' + data.reason +
            ', adNetwork:' + data.adNetwork +
            ', adType:' + data.adType +
            ', adEvent:' + data.adEvent); // adType: 'banner', 'interstitial', etc.*/
        });
        
}
        
function onDeviceReady() {
    if (! AdMob) { alert( 'admob plugin not ready' ); return; }
    initialization();
    // display a banner at startup
    createSelectedBanner();
}

$(document).ready(function(){
				Page.init();
    // on mobile device, we must wait the 'deviceready' event fired by cordova
    if(/(ipad|iphone|ipod|android|windows phone)/i.test(navigator.userAgent)) {
        document.addEventListener('deviceready', onDeviceReady, false);
    } else {
        onDeviceReady();
    }
});
  