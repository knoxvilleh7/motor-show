package project.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 16.08.2016.
 */
public class ModelValidator {

    private Validator validator = new Validator();

    public Map<String, List<String>> mValid(Object object) {

        List<ConstraintViolation> errs = validator.validate(object);
        Map<String, List<String>> msg = new HashMap<String, List<String>>();
        if (errs.size() > 0) {
            for (ConstraintViolation cv : errs){
                String key = (((FieldContext)cv.getContext()).getField().getName());
                List<String> list = msg.get(key);
                if(list ==null){
                    list = new ArrayList<String>();
                    list.add(cv.getMessage());
                }else{
                    list.add(cv.getMessage());
                }
                msg.put(key, list);
            }
        }
        return msg;
    }
}
