package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class AphroditeHeartbreak extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AphroditeHeartbreak.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 8;
    private static final int WEAK = 2;
    private static final int UPG_COST = 1;
    public AphroditeHeartbreak() {
        super(cardInfo, false);
        setDamage(DMG);
        setMagic(WEAK);
        setCostUpgrade(UPG_COST);
        this.tags.add(hadesCards.APHRODITE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, this.damage);
        doPow(m, new WeakPower(m, magicNumber, false));
    }
}