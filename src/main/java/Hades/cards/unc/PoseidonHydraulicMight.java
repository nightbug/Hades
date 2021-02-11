package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class PoseidonHydraulicMight extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            PoseidonHydraulicMight.class.getSimpleName(),
            COSTS[1],
            CardType.ATTACK,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 3;

    public PoseidonHydraulicMight() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true);
        setInnate(true);
        this.tags.add(hadesCards.POSEIDON);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doDmg(m, damage); }
}