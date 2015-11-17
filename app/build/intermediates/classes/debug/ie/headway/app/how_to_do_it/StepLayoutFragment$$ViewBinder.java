// Generated code from Butter Knife. Do not modify!
package ie.headway.app.how_to_do_it;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class StepLayoutFragment$$ViewBinder<T extends ie.headway.app.how_to_do_it.StepLayoutFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492959, "field 'mStepTextView'");
    target.mStepTextView = finder.castView(view, 2131492959, "field 'mStepTextView'");
    view = finder.findRequiredView(source, 2131492960, "field 'mImageView'");
    target.mImageView = finder.castView(view, 2131492960, "field 'mImageView'");
  }

  @Override public void unbind(T target) {
    target.mStepTextView = null;
    target.mImageView = null;
  }
}
