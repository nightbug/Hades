package Hades.actions.unique.AphroditeDyingLament;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MinionPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

import static Hades.util.actionShortcuts.att;
import static Hades.util.actionShortcuts.doAllDmg;

public class AphroditeDyingLamentAction extends AbstractGameAction {

    private DamageInfo primary;
    private DamageInfo secondary;


    public AphroditeDyingLamentAction(AbstractMonster target, DamageInfo primaryDamage, DamageInfo secondaryDamage) {
        this.target = target;
        primary = primaryDamage;
        secondary = secondaryDamage;
        this.actionType = AbstractGameAction.ActionType.DAMAGE;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.NONE));
            this.target.damage(primary);
            if ((((AbstractMonster) this.target).isDying || this.target.currentHealth <= 0) && !this.target.halfDead) { doAllDmg(secondary.base, DamageInfo.DamageType.NORMAL, AttackEffect.NONE, true); }
        }
        tickDuration();
    }
}