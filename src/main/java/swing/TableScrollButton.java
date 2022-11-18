package swing;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TableScrollButton extends JLayeredPane {

    private float animate;
    private boolean show = false;
    private Animator animator;
    private Animator animatorScroll;

    public TableScrollButton() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        animator = new Animator(300, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    animate = fraction;
                } else {
                    animate = 1f - fraction;
                }
                repaint();
            }
        });
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(5);
        animatorScroll = new Animator(300);
        animatorScroll.setAcceleration(.5f);
        animatorScroll.setDeceleration(.5f);
        animatorScroll.setResolution(5);
    }

    private void start(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }
}