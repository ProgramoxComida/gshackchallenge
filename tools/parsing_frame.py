import pandas as pd
import json

dt = pd.read_excel('../backend/public/stockKeepingUnitReport_Dummy_HackChallenge.xls')

selected = dt[['_SkuId (Not changeable)', '_SkuName','_ProductShortDescription', '_MetaTagDescription',  '_DepartamentId (Not changeable)', '_DepartamentName', '_CategoryId', '_CategoryName', '_BrandId', '_Brand']]
print(selected.head())
selected.columns = ['SKU', 'SKU_NAME', 'PRODUCT_SHORT_DESC', 'META_DESC', 'DEPARTAMENT_ID', 'DEPARTAMENT', 'CATEGORY_ID', 'CATEGORY', 'BRAND_ID', 'BRAND']
print(selected.head())

jsonstr = selected.to_json('data.json', orient="records")