package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;

public class ArtemisSupportFire extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ArtemisSupportFire.class.getSimpleName(),
            COSTS[0],
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 4;
    private static final int UPG_DMG = 2;
    public ArtemisSupportFire() {
        super(cardInfo, false);
        setDamage(DMG, UPG_DMG);
        this.tags.add(hadesCards.ARTEMIS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doDmg(m, this.damage); }
}