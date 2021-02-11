package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class PoseidonTempestStrike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            PoseidonTempestStrike.class.getSimpleName(),
            COSTS[2],
            CardType.ATTACK,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 3;
    private static final int ALT_DAMAGE = 2;
    private static final int UPG_ALT_DAMAGE = 2;
    public PoseidonTempestStrike() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(ALT_DAMAGE, UPG_ALT_DAMAGE);
        this.tags.add(hadesCards.POSEIDON);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, damage);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                for(AbstractMonster mo: getAliveMonsters()){
                    if(!mo.equals(m)){ doDmg(mo, magicNumber, DamageInfo.DamageType.NORMAL, AttackEffect.NONE, true); }
                }
                this.isDone = true;
            }
        });
    }
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
