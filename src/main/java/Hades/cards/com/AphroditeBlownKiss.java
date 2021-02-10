package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.powers.DoomPower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.watcher.TriggerMarksAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AphroditeBlownKiss extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AphroditeBlownKiss.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.ATTACK,
            CardTarget.ALL_ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 6;
    private static final int UPG_DMG = 3;
    private static final int WEAK = 1;
    public AphroditeBlownKiss() {
        super(cardInfo, false);
        setDamage(DMG, UPG_DMG);
        setMagic(WEAK);
        tags.add(hadesCards.APHRODITE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doAllDmg(damage, AbstractGameAction.AttackEffect.NONE, false);
        for(AbstractMonster mo: getAliveMonsters()){ doPow(mo, new WeakPower(mo, magicNumber, false)); }
    }
}