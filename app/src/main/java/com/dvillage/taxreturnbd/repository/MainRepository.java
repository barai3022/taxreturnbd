package com.dvillage.taxreturnbd.repository;


import static android.provider.Settings.Global.getString;

import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.A24Model;
import com.dvillage.taxreturnbd.model.FormModel;
import com.dvillage.taxreturnbd.model.Ga11Model;
import com.dvillage.taxreturnbd.model.NoticeModel;
import com.dvillage.taxreturnbd.model.RebateModel;
import com.dvillage.taxreturnbd.model.SalariesModel;
import com.dvillage.taxreturnbd.model.TaxYearModel;
import com.dvillage.taxreturnbd.model.TinModel;
import com.dvillage.taxreturnbd.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class MainRepository {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public MutableLiveData<UserModel> getUserMutableLiveData() {
        MutableLiveData<UserModel> getUser = new MutableLiveData<>();
        String uid = mAuth.getUid();
        db.collection("user").document(uid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            UserModel userModel = task.getResult().toObject(UserModel.class);
                            getUser.setValue(userModel);
                        }
                    }
                });

        return getUser;
    }

    public MutableLiveData<TinModel> getTinMutableLiveData(String tin) {
        MutableLiveData<TinModel> getTinData = new MutableLiveData<>();
        db.collection("tin").document(tin)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            long ga1111;
                            Boolean ga1102, ga1109, ga1110a, ga1110b, ga1110c, ga1110d;

                            if (task.getResult().getBoolean("ga1102") == null) { ga1102 = true; } else { ga1102 = task.getResult().getBoolean("ga1102"); }
                            String ga1103 = task.getResult().getString("ga1103");
                            String ga1104 = task.getResult().getString("ga1104");
                            String ga1105 = task.getResult().getString("ga1105");
                            String ga1106 = task.getResult().getString("ga1106");
                            String ga1107 = task.getResult().getString("ga1107");
                            String ga1108 = task.getResult().getString("ga1108");
                            if (task.getResult().getBoolean("ga1109") == null) { ga1109 = true; } else { ga1109 = task.getResult().getBoolean("ga1109"); }
                            if (task.getResult().getBoolean("ga1110a") == null) { ga1110a = false; } else { ga1110a = task.getResult().getBoolean("ga1110a"); }
                            if (task.getResult().getBoolean("ga1110b") == null) { ga1110b = false; } else { ga1110b = task.getResult().getBoolean("ga1110b"); }
                            if (task.getResult().getBoolean("ga1110c") == null) { ga1110c = false; } else { ga1110c = task.getResult().getBoolean("ga1110c"); }
                            if (task.getResult().getBoolean("ga1110d") == null) { ga1110d = false; } else { ga1110d = task.getResult().getBoolean("ga1110d"); }
                            if (task.getResult().getLong("ga1111") == null) { ga1111 = 0; } else { ga1111 = task.getResult().getLong("ga1111"); }
                            String ga1113 = task.getResult().getString("ga1113");
                            String ga1114 = task.getResult().getString("ga1114");
                            String ga1115 = task.getResult().getString("ga1115");
                            String ga1116 = task.getResult().getString("ga1116");
                            String ga1117 = task.getResult().getString("ga1117");
                            String ga1118 = task.getResult().getString("ga1118");
                            String ga1119 = task.getResult().getString("ga1119");
                            String ga1120 = task.getResult().getString("ga1120");
                            String ga1121 = task.getResult().getString("ga1121");
                            String ga1122 = task.getResult().getString("ga1122");
                            String ga1123 = task.getResult().getString("ga1123");

                            TinModel tinModel = new TinModel(ga1102, ga1103, ga1104, ga1105, ga1106, ga1107, ga1108,
                                    ga1109, ga1110a, ga1110b, ga1110c, ga1110d, ga1111, ga1113,ga1114,ga1115,
                                    ga1116, ga1117, ga1118, ga1119, ga1120, ga1121,ga1122,ga1123);

                            getTinData.setValue(tinModel);
                        }


                    }
                });
        ;
        return getTinData;
    }


    public MutableLiveData<String> setTinMutableLiveData(TinModel tinModel) {
        MutableLiveData<String> setTinStatus = new MutableLiveData<>();
        String ga1105 = tinModel.getGa1105();
        db.collection("tin").document(ga1105)
                .set(tinModel)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            setTinStatus.setValue("Okay");
                        } else {
                            setTinStatus.setValue(task.getException().toString());
                        }
                    }
                });
        return setTinStatus;
    }

    public MutableLiveData<List<TaxYearModel>> getTaxYearListMutableLiveData() {
        MutableLiveData<List<TaxYearModel>> taxYearList = new MutableLiveData<>();

        List<TaxYearModel> taxYearModelList = new ArrayList<>();

        db.collection("user").document(mAuth.getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String tin = task.getResult().getString("tin");
                            db.collection("tin").document(tin).collection("tax_year")
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            if (task.isSuccessful()) {
                                                for (QueryDocumentSnapshot document : task.getResult()) {
                                                    TaxYearModel taxYearModel = document.toObject(TaxYearModel.class);
                                                    taxYearModelList.add(taxYearModel);
                                                }
                                                taxYearList.setValue(taxYearModelList);
                                            }
                                        }
                                    });
                        }
                    }
                });

        return taxYearList;
    }

    public MutableLiveData<String> setTaxYearModelMutableLiveData(TaxYearModel taxYearModel) {
        MutableLiveData<String> setTaxYearModelStatus = new MutableLiveData<>();
        db.collection("user").document(mAuth.getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String tin = task.getResult().getString("tin");
                            String taxYear = taxYearModel.getTax_year();

                            db.collection("tin").document(tin).collection("tax_year").document(taxYear)
                                    .set(taxYearModel)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {

                                               List<FormModel> modelList = new ArrayList<>();
                                               modelList.add(new FormModel(tin, taxYear, "24A","a24", "Particulars of income from Salaries", 1));
                                               modelList.add(new FormModel(tin, taxYear,"24B", "b24", "Particulars of income from house property", 2));
                                               modelList.add(new FormModel(tin, taxYear,"24C", "c24","Summary of income from business or profession", 3));
                                               modelList.add(new FormModel(tin, taxYear,"24D", "d24","Particulars of tax credit/rebate", 4));
                                               modelList.add(new FormModel(tin, taxYear,"11GA2016", "ga11", "RETURN OF INCOME", 5));
                                               modelList.add(new FormModel(tin, taxYear,"10BB2016", "bb10", "STATEMENT OF EXPENSES RELATING TO LIFESTYLE", 6));
                                               modelList.add(new FormModel(tin, taxYear,"10B2016","b10", "STATEMENT OF ASSETS, LIABILITIES AND EXPENSES", 7));
                                               for (FormModel form : modelList) {

                                                  db.collection("tin").document(tin).collection("tax_year").document(taxYear).collection("list_form").document(form.getName())
                                                          .set(form);

                                               }

                                                setTaxYearModelStatus.setValue("Okay");
                                            } else {
                                                setTaxYearModelStatus.setValue(task.getException().toString());
                                            }
                                        }
                                    });
                        }
                    }


                });

        return setTaxYearModelStatus;
    }

    public MutableLiveData<List<FormModel>> getFormListMutableLiveData(String taxYear){
        MutableLiveData<List<FormModel>> getFormList = new MutableLiveData<>();
        List<FormModel> modelList = new ArrayList<>();
        db.collection("user").document(mAuth.getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String tin = task.getResult().getString("tin");
                            db.collection("tin").document(tin).collection("tax_year").document(taxYear).collection("list_form")
                                    .orderBy("index", Query.Direction.ASCENDING)
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                FormModel formModel = document.toObject(FormModel.class);
                                                modelList.add(formModel);
                                            }
                                            getFormList.setValue(modelList);
                                        }
                                    });
                        }
                    }
                });


        return getFormList;
    }
    public MutableLiveData<SalariesModel> getSalariesMutableLiveData(String ga1101, String ga1105) {
        MutableLiveData<SalariesModel> getSalariesData = new MutableLiveData<>();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("a24")
            .get()
            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        long a2403, a2404, a2405, a2406, a2407, a2408, a2409, a2410, a2411, a2412, a2413, a2414, a2415, a2416, a2417, a2418, a2419, a2420, a2421;
                        String tin = task.getResult().getString("tin");
                        String taxYear = task.getResult().getString("tax_year");
                        if (task.getResult().getLong("a2403") == null) {
                            a2403 = 0;
                        } else {
                            a2403 = task.getResult().getLong("a2403");
                        }
                        if (task.getResult().getLong("a2404") == null) {
                            a2404 = 0;
                        } else {
                            a2404 = task.getResult().getLong("a2404");
                        }
                        if (task.getResult().getLong("a2405") == null) {
                            a2405 = 0;
                        } else {
                            a2405 = task.getResult().getLong("a2405");
                        }
                        if (task.getResult().getLong("a2406") == null) {
                            a2406 = 0;
                        } else {
                            a2406 = task.getResult().getLong("a2406");
                        }
                        if (task.getResult().getLong("a2407") == null) {
                            a2407 = 0;
                        } else {
                            a2407 = task.getResult().getLong("a2407");
                        }
                        if (task.getResult().getLong("a2408") == null) {
                            a2408 = 0;
                        } else {
                            a2408 = task.getResult().getLong("a2408");
                        }
                        if (task.getResult().getLong("a2409") == null) {
                            a2409 = 0;
                        } else {
                            a2409 = task.getResult().getLong("a2409");
                        }
                        if (task.getResult().getLong("a2410") == null) {
                            a2410 = 0;
                        } else {
                            a2410 = task.getResult().getLong("a2410");
                        }
                        if (task.getResult().getLong("a2411") == null) {
                            a2411 = 0;
                        } else {
                            a2411 = task.getResult().getLong("a2411");
                        }
                        if (task.getResult().getLong("a2412") == null) {
                            a2412 = 0;
                        } else {
                            a2412 = task.getResult().getLong("a2412");
                        }
                        if (task.getResult().getLong("a2413") == null) {
                            a2413 = 0;
                        } else {
                            a2413 = task.getResult().getLong("a2413");
                        }
                        if (task.getResult().getLong("a2414") == null) {
                            a2414 = 0;
                        } else {
                            a2414 = task.getResult().getLong("a2414");
                        }
                        if (task.getResult().getLong("a2415") == null) {
                            a2415 = 0;
                        } else {
                            a2415 = task.getResult().getLong("a2415");
                        }
                        if (task.getResult().getLong("a2416") == null) {
                            a2416 = 0;
                        } else {
                            a2416 = task.getResult().getLong("a2416");
                        }
                        if (task.getResult().getLong("a2417") == null) {
                            a2417 = 0;
                        } else {
                            a2417 = task.getResult().getLong("a2417");
                        }
                        if (task.getResult().getLong("a2418") == null) {
                            a2418 = 0;
                        } else {
                            a2418 = task.getResult().getLong("a2418");
                        }
                        if (task.getResult().getLong("a2419") == null) {
                            a2419 = 0;
                        } else {
                            a2419 = task.getResult().getLong("a2419");
                        }
                        if (task.getResult().getLong("a2420") == null) {
                            a2420 = 0;
                        } else {
                            a2420 = task.getResult().getLong("a2420");
                        }
                        if (task.getResult().getLong("a2421") == null) {
                            a2421 = 0;
                        } else {
                            a2421 = task.getResult().getLong("a2421");
                        }

                        SalariesModel salariesModel = new SalariesModel(tin, taxYear, a2403, a2404, a2405, a2406, a2407, a2408, a2409, a2410, a2411, a2412, a2413, a2414, a2415, a2416, a2417, a2418, a2419, a2420, a2421);
                        getSalariesData.setValue(salariesModel);
                    }
                }
            });

        return getSalariesData;
    }

    public MutableLiveData<String> setSalariesMutableLiveData(SalariesModel salariesModel) {
        MutableLiveData<String> setSalariesStatus = new MutableLiveData<>();

        String ga1101 = salariesModel.getGa1101();
        String ga1105 = salariesModel.getGa1105();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("a24")
                .set(salariesModel)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            setSalariesStatus.setValue("Okay");
                        } else {
                            setSalariesStatus.setValue(task.getException().toString());
                        }
                    }
                });

        return setSalariesStatus;
    }

    public MutableLiveData<List<A24Model>> getA24MutableLiveData(String ga1101, String ga1105) {
        MutableLiveData<List<A24Model>> getA24Data = new MutableLiveData<>();
        List<A24Model> a24ModelList = new ArrayList<>();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("a24")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            long amount = 0;
                            long exempted = 0;
                            long taxable = 0;
                            long sumAmount = 0;
                            long sumExempted= 0;
                            long sumTaxable =0;
                            if (task.getResult().getLong("a2403") == null) {
                                a24ModelList.add(new A24Model("03 Basic pay", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2403");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("03 Basic pay", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2404") == null) {
                                a24ModelList.add(new A24Model("04 Special pay", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2404");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("04 Special pay", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2405") == null) {
                                a24ModelList.add(new A24Model("05 Arrea pay (if not included in taxable income earlier)", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2405");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("05 Arrea pay (if not included in taxable income earlier)", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2406") == null) {
                                a24ModelList.add(new A24Model("06 Dearness allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2406");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("06 Dearness allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2407") == null) {
                                a24ModelList.add(new A24Model("07 House rent allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2407");
                                if (amount > 300000) {
                                    exempted = 300000;
                                    taxable = amount - 300000;
                                } else {
                                    exempted = amount;
                                    taxable = 0;
                                }
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("07 House rent allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2408") == null) {
                                a24ModelList.add(new A24Model("08 Medical allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2408");
                                if (amount > 120000) {
                                    exempted = 120000;
                                    taxable = amount - 120000;
                                } else {
                                    exempted = amount;
                                    taxable = 0;
                                }
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("08 Medical allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2409") == null) {
                                a24ModelList.add(new A24Model("09 Conveyance allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2409");
                                if (amount > 30000) {
                                    exempted = 30000;
                                    taxable = amount - 30000;
                                } else {
                                    exempted = amount;
                                    taxable = 0;
                                }
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("09 Conveyance allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2410") == null) {
                                a24ModelList.add(new A24Model("10 Festival Allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2410");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("10 Festival Allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2411") == null) {
                                a24ModelList.add(new A24Model("11 Allowance for support staff", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2411");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("11 Allowance for support staff", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2412") == null) {
                                a24ModelList.add(new A24Model("12 Leave allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2412");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("12 Leave allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2413") == null) {
                                a24ModelList.add(new A24Model("13 Honorarium/ Reward/Fee", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2413");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("13 Honorarium/ Reward/Fee", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2414") == null) {
                                a24ModelList.add(new A24Model("14 Overtime allowance", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2414");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("14 Overtime allowance", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2415") == null) {
                                a24ModelList.add(new A24Model("15 Bonus / Ex-gratia", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2415");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("15 Bonus / Ex-gratia", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2416") == null) {
                                a24ModelList.add(new A24Model("16 Other allowances", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2416");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("16 Other allowances", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2417") == null) {
                                a24ModelList.add(new A24Model("17 Employer’s contribution to a recognized provident fund", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2417");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("17 Employer’s contribution to a recognized provident fund", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2418") == null) {
                                a24ModelList.add(new A24Model("18 Interest accrued on a recognized provident fund", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2418");
                                exempted = amount;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("18 Interest accrued on a recognized provident fund", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2419") == null) {
                                a24ModelList.add(new A24Model("19 Deemed income for transport facility", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2419");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("19 Deemed income for transport facility", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2420") == null) {
                                a24ModelList.add(new A24Model("20 Deemed income for free furnished/ unfurnished accommodation", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2420");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("20 Deemed income for free furnished/ unfurnished accommodation", amount, exempted, taxable));
                            }
                            if (task.getResult().getLong("a2421") == null) {
                                a24ModelList.add(new A24Model("21 Other, if any (give detail)", 0, 0, 0));
                            } else {
                                amount = task.getResult().getLong("a2421");
                                exempted = 0;
                                taxable = amount-exempted;
                                sumAmount += amount;
                                sumExempted +=exempted;
                                sumTaxable +=taxable;
                                a24ModelList.add(new A24Model("21 Other, if any (give detail)", amount, exempted, taxable));
                            }
                            a24ModelList.add(new A24Model("Total", sumAmount, sumExempted, sumTaxable));


                            getA24Data.setValue(a24ModelList);
                        }
                    }


                });

        return getA24Data;
    }

    public MutableLiveData<RebateModel> getRebateMutableLiveData(String ga1101, String ga1105){
        MutableLiveData<RebateModel> getRebate = new MutableLiveData<>();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("d24")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            long d2403,d2404,d2405,d2406,d2407,d2409,d2410,d2411,d2412;
                            String ga1101 = task.getResult().getString("ga1101");
                            String ga1105 = task.getResult().getString("ga1105");
                            if (task.getResult().getLong("d2403") == null) { d2403 = 0;} else { d2403 = task.getResult().getLong("d2403"); }
                            if (task.getResult().getLong("d2404") == null) { d2404 = 0;} else { d2404 = task.getResult().getLong("d2404"); }
                            if (task.getResult().getLong("d2405") == null) { d2405 = 0;} else { d2405 = task.getResult().getLong("d2405"); }
                            if (task.getResult().getLong("d2406") == null) { d2406 = 0;} else { d2406 = task.getResult().getLong("d2406"); }
                            if (task.getResult().getLong("d2407") == null) { d2407 = 0;} else { d2407 = task.getResult().getLong("d2407"); }
                            if (task.getResult().getLong("d2409") == null) { d2409 = 0;} else { d2409 = task.getResult().getLong("d2409"); }
                            if (task.getResult().getLong("d2410") == null) { d2410 = 0;} else { d2410 = task.getResult().getLong("d2410"); }
                            if (task.getResult().getLong("d2411") == null) { d2411 = 0;} else { d2411 = task.getResult().getLong("d2411"); }
                            if (task.getResult().getLong("d2412") == null) { d2412 = 0;} else { d2412 = task.getResult().getLong("d2412"); }
                            String d2412l = task.getResult().getString("d2412l");
                            getRebate.setValue(new RebateModel(ga1101, ga1105, d2403,d2404,d2405,d2406,d2407,d2409,d2410,d2411,d2412l, d2412));
                        }
                    }
                });



        return getRebate;
    }
    public MutableLiveData<String> setRebateMutableLiveData(RebateModel rebateModel) {
        MutableLiveData<String> setRebate = new MutableLiveData<>();

        String ga1101 = rebateModel.getGa1101();
        String ga1105 = rebateModel.getGa1105();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("d24")
                .set(rebateModel)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            setRebate.setValue("Okay");
                        } else {
                            setRebate.setValue(task.getException().toString());
                        }
                    }
                });


        return setRebate;
    }

    public MutableLiveData<Ga11Model> getG11DataMutableLiveData(String ga1101, String ga1105){
        MutableLiveData<Ga11Model> getG11Data = new MutableLiveData<>();

        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("ga11")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String ga1101, ga1105, ga1112, ga1154b;
                            long tax_limit_00, tax_limit_05, tax_limit_10, tax_limit_15, tax_limit_20, ga1125, ga1127, ga1129, ga1130, ga1131, ga1132, ga1133, ga1138, ga1139, ga1140, ga1142, ga1143, ga1144, ga1145, ga1154a;
                            boolean ga1150, ga1151, ga1152a, ga1152b, ga1152c, ga1152d, ga1153a, ga1153b;
                            ga1101 = task.getResult().getString("ga1101");
                            ga1105 = task.getResult().getString("ga1105");
                            if (task.getResult().getLong("tax_limit_00") == null) {
                                tax_limit_00 = 0;
                            } else {
                                tax_limit_00 = task.getResult().getLong("tax_limit_00");
                            }
                            if (task.getResult().getLong("tax_limit_05") == null) {
                                tax_limit_05 = 0;
                            } else {
                                tax_limit_05 = task.getResult().getLong("tax_limit_05");
                            }
                            if (task.getResult().getLong("tax_limit_10") == null) {
                                tax_limit_10 = 0;
                            } else {
                                tax_limit_10 = task.getResult().getLong("tax_limit_10");
                            }
                            if (task.getResult().getLong("tax_limit_15") == null) {
                                tax_limit_15 = 0;
                            } else {
                                tax_limit_15 = task.getResult().getLong("tax_limit_15");
                            }
                            if (task.getResult().getLong("tax_limit_20") == null) {
                                tax_limit_20 = 0;
                            } else {
                                tax_limit_20 = task.getResult().getLong("tax_limit_20");
                            }
                            ga1112 = task.getResult().getString("ga1112");
                            if (task.getResult().getLong("ga1125") == null) {
                                ga1125 = 0;
                            } else {
                                ga1125 = task.getResult().getLong("ga1125");
                            }
                            if (task.getResult().getLong("ga1127") == null) {
                                ga1127 = 0;
                            } else {
                                ga1127 = task.getResult().getLong("ga1127");
                            }
                            if (task.getResult().getLong("ga1129") == null) {
                                ga1129 = 0;
                            } else {
                                ga1129 = task.getResult().getLong("ga1129");
                            }
                            if (task.getResult().getLong("ga1130") == null) {
                                ga1130 = 0;
                            } else {
                                ga1130 = task.getResult().getLong("ga1130");
                            }
                            if (task.getResult().getLong("ga1131") == null) {
                                ga1131 = 0;
                            } else {
                                ga1131 = task.getResult().getLong("ga1131");
                            }
                            if (task.getResult().getLong("ga1132") == null) {
                                ga1132 = 0;
                            } else {
                                ga1132 = task.getResult().getLong("ga1132");
                            }
                            if (task.getResult().getLong("ga1133") == null) {
                                ga1133 = 0;
                            } else {
                                ga1133 = task.getResult().getLong("ga1133");
                            }
                            if (task.getResult().getLong("ga1138") == null) {
                                ga1138 = 0;
                            } else {
                                ga1138 = task.getResult().getLong("ga1138");
                            }
                            if (task.getResult().getLong("ga1139") == null) {
                                ga1139 = 0;
                            } else {
                                ga1139 = task.getResult().getLong("ga1139");
                            }
                            if (task.getResult().getLong("ga1140") == null) {
                                ga1140 = 0;
                            } else {
                                ga1140 = task.getResult().getLong("ga1140");
                            }
                            if (task.getResult().getLong("ga1142") == null) {
                                ga1142 = 0;
                            } else {
                                ga1142 = task.getResult().getLong("ga1142");
                            }
                            if (task.getResult().getLong("ga1143") == null) {
                                ga1143 = 0;
                            } else {
                                ga1143 = task.getResult().getLong("ga1143");
                            }
                            if (task.getResult().getLong("ga1144") == null) {
                                ga1144 = 0;
                            } else {
                                ga1144 = task.getResult().getLong("ga1144");
                            }
                            if (task.getResult().getLong("ga1145") == null) {
                                ga1145 = 0;
                            } else {
                                ga1145 = task.getResult().getLong("ga1145");
                            }
                            if (task.getResult().getLong("ga1145") == null) {
                                ga1145 = 0;
                            } else {
                                ga1145 = task.getResult().getLong("ga1145");
                            }
                            if (task.getResult().getBoolean("ga1150") == null) {
                                ga1150 = false;
                            } else {
                                ga1150 = task.getResult().getBoolean("ga1150");
                            }
                            if (task.getResult().getBoolean("ga1151") == null) {
                                ga1151 = false;
                            } else {
                                ga1151 = task.getResult().getBoolean("ga1151");
                            }
                            if (task.getResult().getBoolean("ga1152a") == null) {
                                ga1152a = false;
                            } else {
                                ga1152a = task.getResult().getBoolean("ga1152a");
                            }
                            if (task.getResult().getBoolean("ga1152b") == null) {
                                ga1152b = false;
                            } else {
                                ga1152b = task.getResult().getBoolean("ga1152b");
                            }
                            if (task.getResult().getBoolean("ga1152c") == null) {
                                ga1152c = false;
                            } else {
                                ga1152c = task.getResult().getBoolean("ga1152c");
                            }
                            if (task.getResult().getBoolean("ga1152d") == null) {
                                ga1152d = false;
                            } else {
                                ga1152d = task.getResult().getBoolean("ga1152d");
                            }
                            if (task.getResult().getBoolean("ga1153a") == null) {
                                ga1153a = false;
                            } else {
                                ga1153a = task.getResult().getBoolean("ga1153a");
                            }
                            if (task.getResult().getBoolean("ga1153b") == null) {
                                ga1153b = false;
                            } else {
                                ga1153b = task.getResult().getBoolean("ga1153b");
                            }
                            if (task.getResult().getLong("ga1154a") == null) {
                                ga1154a = 0;
                            } else {
                                ga1154a = task.getResult().getLong("ga1154a");
                            }
                            ga1154b = task.getResult().getString("ga1154b");

                            getG11Data.setValue(new Ga11Model(ga1101, ga1105, tax_limit_00, tax_limit_05,tax_limit_10, tax_limit_15, tax_limit_20, ga1112, ga1125, ga1127, ga1129, ga1130, ga1131, ga1132, ga1133, ga1138, ga1139, ga1140, ga1142, ga1143, ga1144, ga1145, ga1150, ga1151, ga1152a, ga1152b, ga1152c, ga1152d, ga1153a,ga1153b, ga1154a,ga1154b));
                        }

                    }
                });



        return getG11Data;
    }
    public MutableLiveData<String> setGa11MutableLiveData(Ga11Model ga11Model) {
        MutableLiveData<String> setGa11status = new MutableLiveData<>();

        String ga1101 = ga11Model.getGa1101();
        String ga1105 = ga11Model.getGa1105();
        db.collection("tin").document(ga1105).collection("tax_year").document(ga1101).collection("return_form").document("ga11")
                .set(ga11Model)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            setGa11status.setValue("Okay");
                        } else {
                            setGa11status.setValue(task.getException().toString());
                        }
                    }
                });

        return setGa11status;

    }

    public MutableLiveData<NoticeModel> getNoticeMutableLiveData(){
        MutableLiveData<NoticeModel> getNotice = new MutableLiveData<>();
        db.collection("notice").document("notice")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            String notice1 = task.getResult().getString("notice1");
                            String notice2 = task.getResult().getString("notice2");
                            getNotice.setValue(new NoticeModel(notice1, notice2));
                        }
                    }
                });
        return getNotice;
    }

}


