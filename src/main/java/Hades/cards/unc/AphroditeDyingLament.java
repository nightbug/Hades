package Hades.cards.unc;

import Hades.actions.unique.AphroditeDyingLament.AphroditeDyingLamentAction;
import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.evacipated.cardcrawl.mod.stslib.powers.StunMonsterPower;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;
import static Hades.util.actionShortcuts.doPow;

public class AphroditeDyingLament extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AphroditeDyingLament.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 10;
    private static final int CLAUSE_DAMAGE = 5;
    private static final int UPG_CLAUSE_DAMAGE = 3;
    public AphroditeDyingLament() {
        super(cardInfo, false);
        setDamage(DAMAGE);
        setMagic(CLAUSE_DAMAGE, UPG_CLAUSE_DAMAGE);
        tags.add(hadesCards.APHRODITE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { atb(new AphroditeDyingLamentAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), new DamageInfo(p, magicNumber, DamageInfo.DamageType.NORMAL))); }
    @Override
    public void applyPowers()
    {
        magicNumber = baseMagicNumber;
        int tmp = baseDamage;
        baseDamage = baseMagicNumber;
        super.applyPowers();
        magicNumber = damage;
        baseDamage = tmp;
        super.applyPowers();
        isMagicNumberModified = (magicNumber != baseMagicNumber);
    }
}