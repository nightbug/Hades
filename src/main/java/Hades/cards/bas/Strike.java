package Hades.cards.bas;

import Hades.cards.abs.abs_hades_card;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;


public class Strike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            Strike.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 6;
    private static final int UPG_DMG = 3;
    public Strike() {
        super(cardInfo, false);
        setDamage(DMG, UPG_DMG);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doDmg(m, this.damage); }
}