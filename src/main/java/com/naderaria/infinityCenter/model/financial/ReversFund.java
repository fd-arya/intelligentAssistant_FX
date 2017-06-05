package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.Fund;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="REVERS_FUNDS")
@DiscriminatorValue("REVERS_FUND")
@NamedQueries({
        @NamedQuery( name = IQueryNames.REVERS_FUND_SELECT_ALL_KEY , query = IQueryNames.REVERS_FUND_SELECT_ALL_VALUE )
})
public class ReversFund extends Fund {

    private static final long serialVersionUID = 1L;
}
