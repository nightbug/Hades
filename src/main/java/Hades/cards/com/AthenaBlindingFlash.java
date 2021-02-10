package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AthenaBlindingFlash extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AthenaBlindingFlash.class.getSimpleName(),
            COSTS[2],
            CardType.ATTACK,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 3;
    private static final int VULNERABLE = 2;
    public AthenaBlindingFlash() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(VULNERABLE);
        this.tags.add(hadesCards.ATHENA);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, damage);
        doPow(m, new VulnerablePower(m, magicNumber, false));
    }
}
