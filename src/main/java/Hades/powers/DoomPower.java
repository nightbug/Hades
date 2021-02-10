package Hades.powers;

import Hades.cards.abs.abs_hades_card;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;
import static Hades.util.actionShortcuts.p;

public class DoomPower extends AbstractPower {

    public static final String POWER_ID = makeID(DoomPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public DoomPower(AbstractMonster target, int amount) {
        name = NAME;
        ID = POWER_ID;
        this.owner = target;
        this.amount = amount;
        type = PowerType.DEBUFF;
        loadRegion("flameBarrier");
        updateDescription();
    }

    public void triggerMarks(AbstractCard card) {
        if (card instanceof abs_hades_card) { addToBot(new LoseHPAction(this.owner, null, this.amount, AbstractGameAction.AttackEffect.FIRE)); }
    }

    @Override
    public void updateDescription() { this.description = String.format(DESCRIPTIONS[0], this.amount); }
}