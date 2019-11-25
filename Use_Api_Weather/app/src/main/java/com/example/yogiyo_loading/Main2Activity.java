package com.example.yogiyo_loading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class Main2Activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈");
        tabSpecHome.setContent(R.id.tabOne);
        tabHost.addTab(tabSpecHome);

        TabHost.TabSpec tabSpecSearch = tabHost.newTabSpec("Search").setIndicator("검색");
        tabSpecSearch.setContent(R.id.tabTwo);
        tabHost.addTab(tabSpecSearch);

        TabHost.TabSpec tabSpecOrderList = tabHost.newTabSpec("Order").setIndicator("주문내역");
        tabSpecOrderList.setContent(R.id.tabThree);
        tabHost.addTab(tabSpecOrderList);

        TabHost.TabSpec tabSpecMy = tabHost.newTabSpec("My").setIndicator("마이요기요");
        tabSpecMy.setContent(R.id.tabFour);
        tabHost.addTab(tabSpecMy);
        tabHost.setCurrentTab(0);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.chick:{

            }
            case R.id.chick2:{

            }
            case R.id.piz:{

            }
            case R.id.piz2:{

            }
            case R.id.leg:{

            }
            case R.id.leg2:{

            }
            case R.id.kor:{

            }
            case R.id.kor2:{

            }
            case R.id.china:{

            }
            case R.id.china2:{

            }
            case R.id.jap:{

            }
            case R.id.jap2:{

            }
            case R.id.dduck:{

            }
            case R.id.dduck2:{

            }
            case R.id.night:{

            }
            case R.id.night2:{

            }
            case R.id.disert:{

            }
            case R.id.disert2:{

            }
        }
    }
}
