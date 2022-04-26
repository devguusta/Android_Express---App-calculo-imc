package com.example.fitnnes.validators;

import androidx.annotation.StringRes;

import com.example.fitnnes.R;

public class ValidatorsInputs {

    @StringRes
    public int imcResponse(double imc){
        if(imc < 15){
            return R.string.imc_severely_low_weight;
        }
        else if (imc < 16) return R.string.imc_very_low_weight;
        else if (imc < 18.5) return R.string.imc_low_weight;
        else if(imc < 25) return R.string.normal;
        else if(imc < 30) return R.string.imc_high_weight;
        else if( imc <35) return R.string.imc_so_high_weight;
        else if(imc < 40) return R.string.imc_severely_high_weight;

        else {
            return R.string.imc_extreme_weight;
        }

    }
}
