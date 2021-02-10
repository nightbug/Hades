package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class ArtemisHideBreaker extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ArtemisHideBreaker.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 6;
    private static final int UPG_DMG = 3;
    private static final int VULN = 1;
    private static final int UPG_VULN = 1;
    public ArtemisHideBreaker() {
        super(cardInfo, false);
        setDamage(DMG, UPG_DMG);
        setMagic(VULN, UPG_VULN);
        this.tags.add(hadesCards.ARTEMIS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, this.damage);
        doPow(m, new VulnerablePower(m, magicNumber, false));
    }
}