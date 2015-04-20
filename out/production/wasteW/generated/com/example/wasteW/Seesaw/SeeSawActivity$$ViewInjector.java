// Generated code from Butter Knife. Do not modify!
package com.example.wasteW.Seesaw;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SeeSawActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.wasteW.Seesaw.SeeSawActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230732, "field '_up'");
    target._up = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131230731, "field '_down'");
    target._down = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131230730, "field '_view'");
    target._view = view;
  }

  public static void reset(com.example.wasteW.Seesaw.SeeSawActivity target) {
    target._up = null;
    target._down = null;
    target._view = null;
  }
}
