package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.powers.DoomPower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.watcher.TriggerMarksAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AresBlackMetal extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresBlackMetal.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.ATTACK,
            CardTarget.ALL_ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 3;
    private static final int HITS = 3;
    private static final int UPG_HITS = 2;
    public AresBlackMetal() {
        super(cardInfo, false);
        setDamage(DMG);
        setMagic(HITS, UPG_HITS);
        tags.add(hadesCards.ARES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < magicNumber; i += 1){ atb(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.NONE)); }
    }
}